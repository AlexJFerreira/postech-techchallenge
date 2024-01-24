package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.dataprovider.database.ClientGateway;
import br.com.postech.techchallenge.core.domain.Client;
import br.com.postech.techchallenge.core.exceptions.ConflictException;
import br.com.postech.techchallenge.core.usecase.RegisterClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientUseCaseImpl implements RegisterClientUseCase {

  private final ClientGateway clientGateway;

  @Override
  public void execute(Client client) {
    var existsByCpf = clientGateway.checkClientRegistrationByCpf(client.getCpf());

    if (existsByCpf) {
      throw new ConflictException("Cliente com CPF %s já está cadastrado".formatted(client.getCpf()));
    }
    clientGateway.registerClient(client);

  }
}
