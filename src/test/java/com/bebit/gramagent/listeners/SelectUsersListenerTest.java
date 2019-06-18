package com.bebit.gramagent.listeners;

import com.bebit.gramagent.ApplicationConstant;
import com.bebit.gramagent.acts.SelectUsersByDatesAct;
import com.bebit.gramagent.service.BrokerService;
import com.bebit.gramagent.service.Client;
import com.bebit.gramagent.service.ClientService;
import com.bebit.gramagent.service.ErrorPublisher;
import com.bebit.gramagent.util.FileUtil;
import com.bebit.gramagent.util.JsonUtil;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class SelectUsersListenerTest {
  @Mock
  private RabbitTemplate rabbitTemplate;
  @Mock
  private BrokerService brokerService;
  @Mock
  private ClientService clientService;
  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Mock
  private ErrorPublisher errorPublisher;
  @InjectMocks
  private SelectUsersListener selectUsersListener;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);

  }
  @Test
  public void receiveMessageWhenRequestHasMissingValues() {
    String retQueName = "anyqueue";
    Mockito.when(brokerService.createResponseQueue(retQueName)).thenReturn(true);
    SelectUsersByDatesAct selectUsersByDatesAct = new SelectUsersByDatesAct();
    selectUsersListener.receiveMessage(retQueName, selectUsersByDatesAct);
    Mockito.verify(errorPublisher, Mockito.times(1)).publish(Mockito.eq(selectUsersByDatesAct),
        Mockito.any(),
        Mockito.eq(retQueName));

  }

  @Test
  public void receiveMessageValidSelectUsersByDatesAct()
      throws IOException {
    String retQueName = "anyqueue";
    String jsonFile = "src/test/resources/select_users_by_date_valid.json";
    byte[] byteArrayFromFile = FileUtil.getByteArrayFromFile(jsonFile);
    String json = new String(byteArrayFromFile);
    SelectUsersByDatesAct selectUsersByDatesAct =
        JsonUtil.getObjectMapper().readValue(json, SelectUsersByDatesAct.class);
    Mockito.when(brokerService.createResponseQueue(retQueName)).thenReturn(true);
    Client client = new Client();
    client.setIsDisabled(false);
    Mockito.when(clientService.getClientByClientId(selectUsersByDatesAct.getClientId()))
        .thenReturn(client);
    selectUsersListener.receiveMessage(retQueName, selectUsersByDatesAct);
    MessageProperties properties =
        new MessageProperties();
    properties.setContentType("application/json");
    Mockito.doNothing().when(rabbitTemplate).send(ApplicationConstant.RMQ_RET_EXCHANGE_NAME,
        retQueName,
        MessageBuilder.withBody("this is response".getBytes()).andProperties(properties).build());
    // TODO Response Body should be changed.
    Mockito.verify(rabbitTemplate, Mockito.times(1)).send(ApplicationConstant.RMQ_RET_EXCHANGE_NAME,
        retQueName,
        MessageBuilder.withBody("this is response".getBytes()).andProperties(properties).build());


  }

}
