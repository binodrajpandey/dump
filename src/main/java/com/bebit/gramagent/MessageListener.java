package com.bebit.gramagent;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
  @RabbitListener(queues = "gma_session")
  public void receiveMessage(byte[] user) {
    System.out.println(new String(user));

  }

}
