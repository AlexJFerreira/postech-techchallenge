package br.com.postech.techchallenge.core.domain.entity;

import br.com.postech.techchallenge.core.domain.enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment {
  private Integer id;
  private Order order;
  private PaymentStatus status;
}
