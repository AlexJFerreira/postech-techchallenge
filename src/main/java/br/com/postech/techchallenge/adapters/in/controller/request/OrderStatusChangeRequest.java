package br.com.postech.techchallenge.adapters.in.controller.request;

import br.com.postech.techchallenge.application.core.domain.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusChangeRequest {
  private OrderStatus orderStatus;
}
