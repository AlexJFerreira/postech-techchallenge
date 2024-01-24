package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.Client;

public interface SearchClientByCpfUseCase {
  Client execute(String cpf);
}
