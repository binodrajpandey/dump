package com.bebit.gramagent.service;

import com.bebit.gramagent.ApplicationConstant;
import com.bebit.gramagent.JsonRet;
import com.bebit.gramagent.acts.SelectUsersByDatesAct;

import java.util.Map;

import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessagePublisherImpl implements MessagePublisher<SelectUsersByDatesAct> {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  public void publish(SelectUsersByDatesAct selectUsersByDates, String queue) {
    int statusCode = ApplicationConstant.SUCCEED;

    MessageProperties properties =
        new MessageProperties();
    properties.setContentType("application/json");

    Map<String, Object> map = properties.getHeaders();
    map.put(ApplicationConstant.UUID, selectUsersByDates.getUuid());
    map.put(ApplicationConstant.CLIENT_ID, selectUsersByDates.getClientId());
    map.put(ApplicationConstant.APP_USER_ID, selectUsersByDates.getAppUserId());
    map.put(ApplicationConstant.STATUS_CODE, statusCode);

    map.put(ApplicationConstant.REQUEST_EXCHANGE_NAME,
        ApplicationConstant.RMQ_REQUESTED_USER_EXCHANGE_NAME_HEADER
            + ApplicationConstant.PROCESS_NAME);
    map.put(ApplicationConstant.REQUEST_QUEUE_NAME,
        ApplicationConstant.RMQ_REQUESTED_USER_QUEUE_NAME_HEADER
            + ApplicationConstant.PROCESS_NAME);
    map.put(ApplicationConstant.REQUEST_ROUTING_KEY_NAME, ApplicationConstant.RMQ_ROUTING_KEY);

    map.put(ApplicationConstant.FILTER_EXCHANGE_NAME,
        ApplicationConstant.RMQ_FILTERED_USER_EXCHANGE_NAME_HEADER
            + ApplicationConstant.PROCESS_NAME);
    map.put(ApplicationConstant.FILTER_QUEUE_NAME,
        ApplicationConstant.RMQ_FILTERED_USER_QUEUE_NAME_HEADER + ApplicationConstant.PROCESS_NAME);
    map.put(ApplicationConstant.FILTER_ROUTING_KEY_NAME, ApplicationConstant.RMQ_ROUTING_KEY);

    properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
    rabbitTemplate.send(ApplicationConstant.RMQ_RET_EXCHANGE_NAME, queue,
        MessageBuilder.withBody(new JsonRet().toString().getBytes()).andProperties(properties)
            .build());
  }

}
