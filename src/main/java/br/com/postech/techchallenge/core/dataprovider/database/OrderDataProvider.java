package br.com.postech.techchallenge.core.dataprovider.database;

import br.com.postech.techchallenge.core.domain.Order;
import br.com.postech.techchallenge.core.domain.enums.OrderStatus;
import java.util.List;
import java.util.Optional;

public interface OrderDataProvider {
  Order createOrder(Order order);

  List<Order> searchOrders();

  Optional<Order> changeOrderStatus(Integer orderId, OrderStatus orderStatus);


}
