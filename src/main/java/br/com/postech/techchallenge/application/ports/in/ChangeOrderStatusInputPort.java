package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.domain.enums.OrderStatus;

public interface ChangeOrderStatusInputPort {
  Order execute(Integer orderId, OrderStatus orderStatus);
}
