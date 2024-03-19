package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.gateway.database.OrderGateway;
import br.com.postech.techchallenge.core.domain.entity.Order;
import br.com.postech.techchallenge.core.usecase.ListOrderUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ListOrderUseCaseImpl implements ListOrderUseCase {

  private final OrderGateway orderGateway;

  @Override
  public List<Order> execute() {
    return orderGateway.searchOrders();
  }
}
