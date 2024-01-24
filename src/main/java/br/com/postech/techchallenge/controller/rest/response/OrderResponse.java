package br.com.postech.techchallenge.controller.rest.response;

import br.com.postech.techchallenge.core.domain.entity.OrderItem;
import br.com.postech.techchallenge.core.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private Integer id;
    private String cpf;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;
}
