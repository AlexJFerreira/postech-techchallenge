package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.Item;

public interface RegisterItemUseCase {
  Item execute(Item item);
}
