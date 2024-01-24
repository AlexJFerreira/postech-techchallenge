package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.Payment;

public interface SearchPaymentByOrderIdUseCase {
  Payment execute(Integer orderId);
}
