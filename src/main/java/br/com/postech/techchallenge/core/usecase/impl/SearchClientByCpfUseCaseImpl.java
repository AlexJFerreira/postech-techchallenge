package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.gateway.database.ClientGateway;
import br.com.postech.techchallenge.core.domain.Client;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.SearchClientByCpfUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchClientByCpfUseCaseImpl implements SearchClientByCpfUseCase {

  private final ClientGateway clientGateway;

  @Override
  public Client execute(String cpf) {
    return clientGateway.searchClientByCpf(cpf)
        .orElseThrow(() -> new NotFoundException(String.format("Client with cpf %s not found", cpf)));
  }
}
