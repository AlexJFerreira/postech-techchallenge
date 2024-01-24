package br.com.postech.techchallenge.core.usecase.impl;

import br.com.postech.techchallenge.core.domain.Payment;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.usecase.ApprovePaymentUseCase;
import br.com.postech.techchallenge.core.dataprovider.database.PaymentDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApprovePaymentUseCaseImpl implements ApprovePaymentUseCase {

  private final PaymentDataProvider paymentDataProvider;

  @Override
  public Payment execute(Integer paymentId) {
    return paymentDataProvider.approvePayment(paymentId)
        .orElseThrow(() -> new NotFoundException(String.format("Payment with id %s not found", paymentId)));
  }
}
