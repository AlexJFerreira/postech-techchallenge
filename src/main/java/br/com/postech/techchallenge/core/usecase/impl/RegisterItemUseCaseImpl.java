package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.domain.Item;
import br.com.postech.techchallenge.core.usecase.RegisterItemUseCase;
import br.com.postech.techchallenge.core.dataprovider.database.ItemDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterItemUseCaseImpl implements RegisterItemUseCase {

  private final ItemDataProvider itemDataProvider;

  @Override
  public Item execute(Item item) {
    return itemDataProvider.registerItem(item);
  }
}
