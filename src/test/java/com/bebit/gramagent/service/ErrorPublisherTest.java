package com.bebit.gramagent.service;

import com.bebit.gramagent.ApplicationConstant;
import com.bebit.gramagent.acts.SelectUsersByDatesAct;
import com.bebit.gramagent.service.exception.AppException;
import com.bebit.gramagent.util.FileUtil;
import com.bebit.gramagent.util.JsonUtil;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ErrorPublisherTest {
  @Mock
  private RabbitTemplate rabbitTemplate;
  @InjectMocks
  private ErrorPublisherImpl errorPublisher;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void publish() throws IOException {
    String jsonFile = "src/test/resources/select_users_by_date_valid.json";
    byte[] byteArrayFromFile = FileUtil.getByteArrayFromFile(jsonFile);
    String json = new String(byteArrayFromFile);
    SelectUsersByDatesAct selectUsersByDatesAct =
        JsonUtil.getObjectMapper().readValue(json, SelectUsersByDatesAct.class);
    AppException appException = new AppException(1, "Invalid request parameter");
    selectUsersByDatesAct.setUtcTimePeriod(-2);
    String queueName="randomqueue";
    Mockito.doNothing().when(rabbitTemplate).send(
        Mockito.eq(ApplicationConstant.RMQ_RET_EXCHANGE_NAME), Mockito.eq(queueName),
        Mockito.any());
    errorPublisher.publish(selectUsersByDatesAct, appException, queueName);
    Mockito.verify(rabbitTemplate, Mockito.times(1)).send(
        Mockito.eq(ApplicationConstant.RMQ_RET_EXCHANGE_NAME), Mockito.eq(queueName),
        Mockito.any());

  }

}
