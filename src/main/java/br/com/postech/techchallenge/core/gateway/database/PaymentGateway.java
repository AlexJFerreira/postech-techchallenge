package br.com.postech.techchallenge.core.gateway.database;

import br.com.postech.techchallenge.core.domain.Payment;
import java.util.Optional;

public interface PaymentGateway {
  Optional<Payment> approvePayment(Integer paymentId);
  Optional<Payment> searchPaymentByOrderId(Integer orderId);

}
