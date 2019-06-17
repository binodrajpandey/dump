package com.bebit.gramagent.service;

import com.bebit.gramagent.ApplicationConstant;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrokerServiceImpl implements BrokerService {
  private static final Logger logger = LoggerFactory.getLogger(BrokerServiceImpl.class);
  @Autowired
  private AmqpAdmin admin;
  @Override
  public boolean createResponseQueue(String name) {
    try {
      // Queue option
      Map<String, Object> queue_args = new HashMap<String, Object>();
      // delete queue after specified time
      queue_args.put("x-expires", ApplicationConstant.RMQ_X_EXPIRES_MSEC);
      Queue queue = new Queue(name, true, false, false, queue_args);
      admin.declareQueue(queue);

      Exchange exchange =
          ExchangeBuilder.directExchange(ApplicationConstant.RMQ_RET_EXCHANGE_NAME).durable(true)
              .build();
      admin.declareExchange(exchange);

      Binding binding = new Binding(name, DestinationType.QUEUE, name, name,
          new HashMap<String, Object>());
      admin.declareBinding(binding);
      return true;
    } catch (Exception ex) {
      logger.error("Couldn't create queue: {}", name);
      return false;
    }


  }

}
