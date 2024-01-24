package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.dataprovider.database.OrderDataProvider;
import br.com.postech.techchallenge.core.domain.Order;
import br.com.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.ChangeOrderStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChangeOrderStatusUseCaseImpl implements ChangeOrderStatusUseCase {

  private final OrderDataProvider orderDataProvider;

  @Override
  public Order execute(Integer orderId, OrderStatus orderStatus) {
    return orderDataProvider.changeOrderStatus(orderId, orderStatus)
        .orElseThrow(() -> new NotFoundException(String.format("Order with id %s not found", orderId)));
  }
}
