package br.com.postech.techchallenge.controller.rest.response;

import br.com.postech.techchallenge.core.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {

  private Integer id;
  private OrderResponse order;
  private PaymentStatus status;
}
