package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.dataprovider.database.ItemGateway;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.DeleteItemUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteItemUseCaseImpl implements DeleteItemUseCase {
  private final ItemGateway itemGateway;

  @Override
  public void execute(Integer id) {
    try {
      itemGateway.deleteItemById(id);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Item not found");
    }
  }
}
