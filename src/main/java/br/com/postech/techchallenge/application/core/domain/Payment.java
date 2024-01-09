package br.com.postech.techchallenge.application.core.domain;

import br.com.postech.techchallenge.application.core.domain.enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment {
  private Integer id;
  private Order order;
  private PaymentStatus status;
}
