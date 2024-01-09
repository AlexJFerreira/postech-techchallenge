package br.com.postech.techchallenge.adapters.in.controller.response;

import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {

  private Integer id;
  private OrderResponse order;
  private PaymentStatus status;
}
