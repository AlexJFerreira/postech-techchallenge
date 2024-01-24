package br.com.postech.techchallenge.core.domain.entity;

import br.com.postech.techchallenge.core.domain.enums.ItemType;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Item {
  private Integer id;
  private String name;
  private String description;
  private BigDecimal price;
  private ItemType type;
}
