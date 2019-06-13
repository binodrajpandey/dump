package com.bebit.gramagent;

import java.util.HashMap;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class GramAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GramAgentApplication.class, args);
	}

  @Autowired
  private GmaSessionConfig rmqConfig;

  /* Creating a bean for the Message queue Exchange */
  @Bean
  public TopicExchange getGmaSessionExchange() {
    TopicExchange topicExchange =
        new TopicExchange(rmqConfig.getExchangeName(), true, false, new HashMap<String, Object>());

    return topicExchange;
  }

  /* Creating a bean for the Message queue */
  @Bean
  public Queue getGmaSessionQueue() {
    Queue queue = new Queue(rmqConfig.getQueueName(), true, false, false, new HashMap<>());
    return queue;
  }

  /* Binding between Exchange and Queue using routing key */
  @Bean
  public Binding declareBindingApp1() {
    return BindingBuilder.bind(getGmaSessionQueue()).to(getGmaSessionExchange())
        .with(rmqConfig.getRoutingKey());
  }


}
