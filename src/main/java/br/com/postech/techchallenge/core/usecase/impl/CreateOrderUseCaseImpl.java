package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.domain.Order;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.CreateOrderUseCase;
import br.com.postech.techchallenge.core.dataprovider.database.OrderDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

  private final OrderDataProvider orderDataProvider;

  @Override
  public Order execute(Order order) {
    try {
      return orderDataProvider.createOrder(order);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Pedido com item não existente, revise o pedido!");
    }
  }
}
