package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Payment;
import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.SearchPaymentByOrderIdInputPort;
import br.com.postech.techchallenge.application.ports.out.SearchPaymentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchPaymentByOrderIdUseCase implements SearchPaymentByOrderIdInputPort {

  private final SearchPaymentOutputPort searchPaymentOutputPort;


  @Override
  public Payment execute(Integer orderId) {
    return searchPaymentOutputPort.execute(orderId)
        .orElseThrow(() -> new NotFoundException(String.format("Payment with order id %s not found", orderId)));
  }
}
