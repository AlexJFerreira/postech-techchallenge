package br.com.postech.techchallenge.core.dataprovider.database;

import br.com.postech.techchallenge.core.domain.Payment;
import java.util.Optional;

public interface PaymentDataProvider {
  Optional<Payment> approvePayment(Integer paymentId);
  Optional<Payment> searchPaymentByOrderId(Integer orderId);

}
