package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Payment;
import java.util.Optional;

public interface ApprovePaymentOutputPort {
  Optional<Payment> execute(Integer paymentId);
}
