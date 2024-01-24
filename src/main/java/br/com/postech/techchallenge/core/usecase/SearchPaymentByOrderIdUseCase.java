package br.com.postech.techchallenge.core.usecase;

import br.com.postech.techchallenge.core.domain.entity.Payment;

public interface SearchPaymentByOrderIdUseCase {
  Payment execute(Integer orderId);
}
