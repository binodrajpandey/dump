package com.bebit.gramagent.service;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
  // TODO we will fetch client information from micro-service.
  public Client getClientByClientId(Integer clientId) {
    Client client = new Client();
    client.setIsDisabled(false);
    return client;
  }

}
