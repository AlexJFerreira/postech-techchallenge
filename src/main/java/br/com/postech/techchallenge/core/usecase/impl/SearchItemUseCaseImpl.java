package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.dataprovider.database.ItemDataProvider;
import br.com.postech.techchallenge.core.domain.Item;
import br.com.postech.techchallenge.core.domain.enums.ItemType;
import br.com.postech.techchallenge.core.usecase.SearchItemUseCase;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchItemUseCaseImpl implements SearchItemUseCase {

  private ItemDataProvider itemDataProvider;

  @Override
  public List<Item> execute(@NotNull ItemType type) {
    try {
      return itemDataProvider.searchItemByType(type);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid item type.");
    }
  }
}
