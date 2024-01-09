package br.com.postech.techchallenge.adapters.in.controller;

import br.com.postech.techchallenge.adapters.in.controller.request.OrderCreationRequest;
import br.com.postech.techchallenge.adapters.in.controller.request.OrderStatusChangeRequest;
import br.com.postech.techchallenge.adapters.in.controller.response.OrderResponse;
import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.ports.in.ChangeOrderStatusInputPort;
import br.com.postech.techchallenge.application.ports.in.CreateOrderInputPort;
import br.com.postech.techchallenge.application.ports.in.ListOrderInputPort;
import jakarta.validation.Valid;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/techchallenge/orders")
public class OrderController {

  private final CreateOrderInputPort createOrderInputPort;
  private final ListOrderInputPort listOrderInputPort;
  private final ChangeOrderStatusInputPort changeOrderStatusInputPort;
  private final ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderResponse orderCreation(@Valid @RequestBody final OrderCreationRequest orderCreationRequest) {
    log.info("Order creation request: {} received", orderCreationRequest);
    var order = modelMapper.map(orderCreationRequest, Order.class);
    return modelMapper.map(createOrderInputPort.execute(order), OrderResponse.class);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<OrderResponse> listAllOrders() {
    log.info("Get all orders request received");
    var orders = listOrderInputPort.execute();
    return orders.stream()
        .map(order -> modelMapper.map(order, OrderResponse.class))
        .toList();
  }

  @PatchMapping("/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public OrderResponse orderStatusChange(@Valid @RequestBody final OrderStatusChangeRequest orderStatusChangeRequest,
                                         @NotNull @PathVariable final Integer orderId) {

    var newOrderstatus = orderStatusChangeRequest.getOrderStatus();

    log.info("Changing order {} to new status: {} ", orderId, newOrderstatus);
    return modelMapper.map(changeOrderStatusInputPort.execute(orderId, newOrderstatus), OrderResponse.class);
  }

}
