package br.com.postech.techchallenge.core.dataprovider.database;

import br.com.postech.techchallenge.core.domain.Client;
import java.util.Optional;

public interface ClientDataProvider {
  void registerClient(Client client);

  Optional<Client> searchClientByCpf(String cpf);

  Boolean checkClientRegistrationByCpf(String cpf);

}
