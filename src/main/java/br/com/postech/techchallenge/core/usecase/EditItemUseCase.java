package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.entity.Item;

public interface EditItemUseCase {
    Item execute(Integer id, Item item);
}
