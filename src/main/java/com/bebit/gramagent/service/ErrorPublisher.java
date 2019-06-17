package com.bebit.gramagent.service;

import com.bebit.gramagent.acts.SelectUsersByDatesAct;
import com.bebit.gramagent.service.exception.AppException;

public interface ErrorPublisher {
  void publish(SelectUsersByDatesAct selectUsersByDates,
      AppException ex, String queueName);

}
