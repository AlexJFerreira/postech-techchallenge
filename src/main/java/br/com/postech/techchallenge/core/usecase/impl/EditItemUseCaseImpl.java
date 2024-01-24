package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.dataprovider.database.ItemDataProvider;
import br.com.postech.techchallenge.core.domain.Item;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.EditItemUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditItemUseCaseImpl implements EditItemUseCase {
  private final ItemDataProvider itemDataProvider;

  @Override
  public Item execute(Integer id, Item item) {
    try {
      return itemDataProvider.editItem(id, item);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Item não encontrado!");
    }
  }
}
