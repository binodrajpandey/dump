package com.bebit.gramagent.service;

import com.bebit.gramagent.ApplicationConstant;
import com.bebit.gramagent.acts.SelectUsersByDatesAct;
import com.bebit.gramagent.service.exception.AppException;

import java.util.Map;

import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErrorPublisherImpl implements ErrorPublisher {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  @Transactional
  public void publish(SelectUsersByDatesAct selectUsersByDates,
      AppException ex, String queueName) {
   int statusCode = ApplicationConstant.ERROR;

    MessageProperties properties =
        new MessageProperties();
    properties.setContentType("application/json");

    Map<String, Object> map = properties.getHeaders();
    map.put(ApplicationConstant.UUID, selectUsersByDates.getUuid());
    map.put(ApplicationConstant.CLIENT_ID, selectUsersByDates.getClientId());
    map.put(ApplicationConstant.APP_USER_ID, selectUsersByDates.getAppUserId());
    map.put(ApplicationConstant.STATUS_CODE, statusCode);
    map.put(ApplicationConstant.ERROR_CODE, ex.getErrorCode());
    map.put(ApplicationConstant.ERROR_MESSAGE, ex.getMessage());
    properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
    rabbitTemplate.send(ApplicationConstant.RMQ_RET_EXCHANGE_NAME, queueName,
        MessageBuilder.withBody("".getBytes()).andProperties(properties)
            .build());


  }

}
