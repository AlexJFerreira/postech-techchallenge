package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.gateway.database.PaymentGateway;
import br.com.postech.techchallenge.core.domain.entity.Payment;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.SearchPaymentByOrderIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchPaymentByOrderIdUseCaseImpl implements SearchPaymentByOrderIdUseCase {

  private final PaymentGateway paymentGateway;


  @Override
  public Payment execute(Integer orderId) {
    return paymentGateway.searchPaymentByOrderId(orderId)
        .orElseThrow(() -> new NotFoundException(String.format("Payment with order id %s not found", orderId)));
  }
}
