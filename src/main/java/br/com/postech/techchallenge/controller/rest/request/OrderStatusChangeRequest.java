package br.com.postech.techchallenge.controller.rest.request;

import br.com.postech.techchallenge.core.domain.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusChangeRequest {
  private OrderStatus orderStatus;
}
