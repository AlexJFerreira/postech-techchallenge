package br.com.postech.techchallenge.controller.rest.response;

import br.com.postech.techchallenge.core.domain.enums.ItemType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private ItemType type;
}
