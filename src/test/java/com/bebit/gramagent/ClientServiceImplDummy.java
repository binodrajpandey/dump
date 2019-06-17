package com.bebit.gramagent;

import com.bebit.gramagent.service.Client;
import com.bebit.gramagent.service.ClientService;

import org.springframework.stereotype.Service;

// TODO should be removed after actual microservice returning client id is done.
@Service
public class ClientServiceImplDummy implements ClientService {
  public Client getClientByClientId(Integer clientId) {
    Client client = new Client();
    client.setIsDisabled(false);
    return client;
  }

}
