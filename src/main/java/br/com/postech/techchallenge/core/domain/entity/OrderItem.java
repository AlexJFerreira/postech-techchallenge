package br.com.postech.techchallenge.core.domain.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItem {
  private Integer itemId;
  private Integer quantity;
  private BigDecimal totalPrice;
}
