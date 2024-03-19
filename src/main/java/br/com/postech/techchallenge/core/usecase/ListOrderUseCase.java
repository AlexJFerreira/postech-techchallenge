package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.entity.Order;

import java.util.List;

public interface ListOrderUseCase {
    List<Order> execute();
}
