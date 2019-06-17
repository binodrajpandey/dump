package com.bebit.gramagent.listeners;

import com.bebit.gramagent.ApplicationConstant;
import com.bebit.gramagent.acts.SelectUsersByDatesAct;
import com.bebit.gramagent.service.BrokerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class SelectUsersListener {
  private static final Logger logger = LoggerFactory.getLogger(SelectUsersListener.class);
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  private BrokerService brokerService;

  @RabbitListener(queues = "${gma-session.queue-name}")
  public void receiveMessage(@Header("ret_queue_name") String retQueName,
      SelectUsersByDatesAct selectUsersByDatesAct) throws Exception {
    logger.info("message received: with header: {} and payload:{}", retQueName,
        selectUsersByDatesAct);

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
}
