package br.com.postech.techchallenge.gateway.database;

import br.com.postech.techchallenge.core.dataprovider.database.ClientGateway;
import br.com.postech.techchallenge.core.domain.Client;
import br.com.postech.techchallenge.gateway.database.entity.ClientEntity;
import br.com.postech.techchallenge.gateway.database.repository.ClientRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientGatewayImpl implements ClientGateway {

  private final ClientRepository clientRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public void registerClient(Client client) {
    var clientEntity = modelMapper.map(client, ClientEntity.class);
    clientRepository.save(clientEntity);
  }

  public Optional<Client> searchClientByCpf(String cpf) {
    return clientRepository.findById(cpf)
        .map(clientEntity -> modelMapper.map(clientEntity, Client.class));
  }

  @Override
  public Boolean checkClientRegistrationByCpf(String cpf) {
    return clientRepository.existsById(cpf);
  }
}
