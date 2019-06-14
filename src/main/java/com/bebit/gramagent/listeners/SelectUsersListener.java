package com.bebit.gramagent.listeners;

import com.bebit.gramagent.acts.SelectUsersByDatesAct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SelectUsersListener {
  Logger logger = LoggerFactory.getLogger(SelectUsersListener.class);

  @RabbitListener(queues = "${gma-session.queue-name}")
  public void receiveMessage(SelectUsersByDatesAct selectUsersByDatesAct) {
    logger.info("message received: {}",selectUsersByDatesAct);
    // TODO process the request
  }
}
