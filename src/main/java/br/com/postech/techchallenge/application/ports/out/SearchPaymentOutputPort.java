package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Payment;
import java.util.Optional;

public interface SearchPaymentOutputPort {
  Optional<Payment> execute(Integer orderId);
}
