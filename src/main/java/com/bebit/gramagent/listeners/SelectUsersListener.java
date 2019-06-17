package com.bebit.gramagent.listeners;

import com.bebit.gramagent.ApplicationConstant;
import com.bebit.gramagent.acts.SelectUsersByDatesAct;
import com.bebit.gramagent.service.BrokerService;
import com.bebit.gramagent.service.Client;
import com.bebit.gramagent.service.ClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SelectUsersListener {
  Logger logger = LoggerFactory.getLogger(SelectUsersListener.class);
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  private BrokerService brokerService;
  @Autowired
  private ClientService clientService;

  @RabbitListener(queues = "${gma-session.queue-name}")
  public void receiveMessage(@Header("ret_queue_name") String retQueName,
      SelectUsersByDatesAct selectUsersByDatesAct) {
    logger.info("message received: with header: {} and payload:{}", retQueName,
        selectUsersByDatesAct);
    validateSelectUsersByDate(selectUsersByDatesAct);


    boolean created = brokerService.createResponseQueue(retQueName);
    if (created) {
      // TODO process the request and send the message to the queue
      MessageProperties properties =
          new MessageProperties();
      properties.setContentType("application/json");
      rabbitTemplate.send(ApplicationConstant.RMQ_RET_EXCHANGE_NAME, retQueName,
          MessageBuilder.withBody("this is response".getBytes()).andProperties(properties).build());
    }


  }

  private void validateSelectUsersByDate(SelectUsersByDatesAct selectUsersByDatesAct) {
    StringBuilder stringBuilder = new StringBuilder();
    if (StringUtils.isEmpty(selectUsersByDatesAct.getUuid())) {
      stringBuilder.append("uuid null or empty.");
    }
    if (selectUsersByDatesAct.getClientId() == null) {
      stringBuilder.append("client_id is null.");

    } else {
      Client client = clientService.getClientByClientId(selectUsersByDatesAct.getClientId());
      if (client == null) {

        stringBuilder
            .append("no client found for given clientId: " + selectUsersByDatesAct.getClientId());
      } else if (client.getIsDisabled()) {

        stringBuilder
            .append("client s_disabled for given clientId: " + selectUsersByDatesAct.getClientId());
      } else {
        // TODO set masterId of the client.
      }
    }
    if (selectUsersByDatesAct.getAppUserId() == null) {
      stringBuilder.append("app_user_id is null");

    }
    if (StringUtils.isEmpty(selectUsersByDatesAct.getLoginSessionKey())) {
      stringBuilder.append("login_session_key is null or empty");
    }
    if (selectUsersByDatesAct.getConversionIds() == null
        || selectUsersByDatesAct.getConversionIds().isEmpty()) {
      stringBuilder.append("conversion id must be present");

    }
    if (selectUsersByDatesAct.getStartTimeSec() == null) {
      stringBuilder.append("start_time_sec must be present");

    }
    if (selectUsersByDatesAct.getEndTimeSec() == null) {
      stringBuilder.append("end_time_sec must be present");
    }
    if ((selectUsersByDatesAct.getStartTimeSec() != null
        && selectUsersByDatesAct.getEndTimeSec() != null)
        && selectUsersByDatesAct.getEndTimeSec() - selectUsersByDatesAct.getStartTimeSec() > 366
            * 24 * 60 * 60) {
      stringBuilder.append("too long span. must be less than or equal to 366 days.");

    }
    if (selectUsersByDatesAct.getUtcTimePeriod() == null) {
      stringBuilder.append("utc_time_period must be present");
    }
    else if (selectUsersByDatesAct.getUtcTimePeriod() < -1
        || selectUsersByDatesAct.getUtcTimePeriod() > 23) {
      stringBuilder.append("utc_time_period must be [-1,23].");
    }

    String errorMessage = stringBuilder.toString();
    if (!errorMessage.isEmpty()) {
      logger.error("Invalid Request Parameters: {}", errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }
}
