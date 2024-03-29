package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.domain.entity.Item;
import br.com.postech.techchallenge.core.usecase.RegisterItemUseCase;
import br.com.postech.techchallenge.core.gateway.database.ItemGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterItemUseCaseImpl implements RegisterItemUseCase {

  private final ItemGateway itemGateway;

  @Override
  public Item execute(Item item) {
    return itemGateway.registerItem(item);
  }
}
