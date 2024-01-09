package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.domain.enums.OrderStatus;
import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.ChangeOrderStatusInputPort;
import br.com.postech.techchallenge.application.ports.out.ApprovePaymentOutputPort;
import br.com.postech.techchallenge.application.ports.out.ChangeOrderStatusOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChangeOrderStatusUseCase implements ChangeOrderStatusInputPort {

  private final ChangeOrderStatusOutputPort changeOrderStatusOutputPort;

  @Override
  public Order execute(Integer orderId, OrderStatus orderStatus) {
    return changeOrderStatusOutputPort.execute(orderId, orderStatus)
        .orElseThrow(() -> new NotFoundException(String.format("Order with id %s not found", orderId)));
  }
}
