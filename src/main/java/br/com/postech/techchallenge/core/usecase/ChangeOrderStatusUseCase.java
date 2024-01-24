package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.entity.Order;
import br.com.postech.techchallenge.core.domain.enums.OrderStatus;

public interface ChangeOrderStatusUseCase {
  Order execute(Integer orderId, OrderStatus orderStatus);
}
