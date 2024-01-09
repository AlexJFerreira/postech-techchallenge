package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Payment;

public interface SearchPaymentByOrderIdInputPort {
  Payment execute(Integer orderId);
}
