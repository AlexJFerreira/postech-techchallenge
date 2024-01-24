package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.dataprovider.database.OrderDataProvider;
import br.com.postech.techchallenge.core.domain.Order;
import br.com.postech.techchallenge.core.usecase.ListOrderUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ListOrderUseCaseImpl implements ListOrderUseCase {

  private final OrderDataProvider orderDataProvider;

  @Override
  public List<Order> execute() {
    return orderDataProvider.searchOrders();
  }
}
