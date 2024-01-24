package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.entity.Item;

import br.com.postech.techchallenge.core.domain.enums.ItemType;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SearchItemUseCase {
    List<Item> execute(@NotNull ItemType type);
}
