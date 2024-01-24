package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.Order;

public interface CreateOrderUseCase {
  Order execute(Order order);

}
