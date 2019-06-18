package com.bebit.gramagent.service;

public interface MessagePublisher<T> {

  public void publish(T message, String queueName);

}
