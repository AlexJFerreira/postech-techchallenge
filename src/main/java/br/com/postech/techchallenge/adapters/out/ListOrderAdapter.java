package br.com.postech.techchallenge.adapters.out;

import static br.com.postech.techchallenge.application.core.domain.enums.OrderStatus.DELIVERED;
import static br.com.postech.techchallenge.application.core.domain.enums.OrderStatus.PREPARING;
import static br.com.postech.techchallenge.application.core.domain.enums.OrderStatus.READY_FOR_PICKUP;
import static br.com.postech.techchallenge.application.core.domain.enums.OrderStatus.RECEIVED;

import br.com.postech.techchallenge.adapters.out.database.repository.OrderRepository;
import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.domain.enums.OrderStatus;
import br.com.postech.techchallenge.application.ports.out.ListOrderOutputPort;
import jakarta.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ListOrderAdapter implements ListOrderOutputPort {
  private static final List<OrderStatus> PAYMENT_STATUS_ORDER = List.of(READY_FOR_PICKUP, PREPARING, RECEIVED);
  public static final Comparator<Order> PAYMENT_STATUS_COMPARATOR = Comparator.comparingInt(o -> {
    int index = PAYMENT_STATUS_ORDER.indexOf(o.getStatus());
    return index == -1 ? Integer.MAX_VALUE : index;
  });
  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public List<Order> execute() {
    var allOrders = orderRepository.findAllByStatusNot(DELIVERED);
    return allOrders.stream()
        .map(order -> modelMapper.map(order, Order.class))
        .sorted((PAYMENT_STATUS_COMPARATOR)
            .thenComparing(Order::getOrderDate))
        .toList();

  }
}
