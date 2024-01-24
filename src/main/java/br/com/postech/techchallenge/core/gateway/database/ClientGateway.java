package br.com.postech.techchallenge.core.gateway.database;

import br.com.postech.techchallenge.core.domain.Client;
import java.util.Optional;

public interface ClientGateway {
  void registerClient(Client client);

  Optional<Client> searchClientByCpf(String cpf);

  Boolean checkClientRegistrationByCpf(String cpf);

}
