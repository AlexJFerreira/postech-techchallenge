package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Payment;
import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.ApprovePaymentInputPort;
import br.com.postech.techchallenge.application.ports.out.ApprovePaymentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApprovePaymentUseCase implements ApprovePaymentInputPort {

  private final ApprovePaymentOutputPort approvePaymentOutputPort;

  @Override
  public Payment execute(Integer paymentId) {
    return approvePaymentOutputPort.execute(paymentId)
        .orElseThrow(() -> new NotFoundException(String.format("Payment with id %s not found", paymentId)));
  }
}
