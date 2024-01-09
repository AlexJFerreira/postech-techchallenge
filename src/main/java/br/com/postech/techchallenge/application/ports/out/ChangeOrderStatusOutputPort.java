package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.domain.enums.OrderStatus;
import java.util.Optional;

public interface ChangeOrderStatusOutputPort {
  Optional<Order> execute(Integer orderId, OrderStatus orderStatus);
}
