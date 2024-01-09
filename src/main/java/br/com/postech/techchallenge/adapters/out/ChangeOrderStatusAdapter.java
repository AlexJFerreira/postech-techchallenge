package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.OrderRepository;
import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.domain.enums.OrderStatus;
import br.com.postech.techchallenge.application.ports.out.ChangeOrderStatusOutputPort;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChangeOrderStatusAdapter implements ChangeOrderStatusOutputPort {

  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public Optional<Order> execute(Integer orderId, OrderStatus orderStatus) {
    var orderEntity = orderRepository.findById(orderId);
    orderEntity.ifPresent(order -> order.setStatus(orderStatus));
    return orderEntity.map(orderEntity1 -> modelMapper.map(orderEntity1, Order.class));
  }
}
