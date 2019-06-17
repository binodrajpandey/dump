package com.bebit.gramagent.service;

public interface ClientService {
  // TODO we will fetch client information from micro-service.
  Client getClientByClientId(Integer clientId);

}
