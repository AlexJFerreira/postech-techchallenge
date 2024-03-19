package br.com.postech.techchallenge.core.gateway.database;

import br.com.postech.techchallenge.core.domain.entity.Order;
import br.com.postech.techchallenge.core.domain.enums.OrderStatus;
import java.util.List;
import java.util.Optional;

public interface OrderGateway {
  Order createOrder(Order order);

  List<Order> searchOrders();

  Optional<Order> changeOrderStatus(Integer orderId, OrderStatus orderStatus);


}
