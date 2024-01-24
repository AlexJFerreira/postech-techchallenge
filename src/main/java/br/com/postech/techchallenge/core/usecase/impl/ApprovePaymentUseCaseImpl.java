package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.domain.Payment;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.ApprovePaymentUseCase;
import br.com.postech.techchallenge.core.dataprovider.database.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApprovePaymentUseCaseImpl implements ApprovePaymentUseCase {

  private final PaymentGateway paymentGateway;

  @Override
  public Payment execute(Integer paymentId) {
    return paymentGateway.approvePayment(paymentId)
        .orElseThrow(() -> new NotFoundException(String.format("Payment with id %s not found", paymentId)));
  }
}
