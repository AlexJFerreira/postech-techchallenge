package br.com.postech.techchallenge.adapters.controller.rest.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;

@Data
public class OrderCreationRequest {

  private String cpf;
  private String name;
  private String email;

  @NotEmpty
  private List<OrderItemRequest> orderItems;
}
