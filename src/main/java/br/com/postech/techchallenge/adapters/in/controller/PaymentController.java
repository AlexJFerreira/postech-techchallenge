package br.com.postech.techchallenge.adapters.in.controller;

import br.com.postech.techchallenge.adapters.in.controller.response.PaymentResponse;
import br.com.postech.techchallenge.application.ports.in.ApprovePaymentInputPort;
import br.com.postech.techchallenge.application.ports.in.SearchPaymentByOrderIdInputPort;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/techchallenge/payments")
public class PaymentController {

  private final ModelMapper modelMapper;
  private final SearchPaymentByOrderIdInputPort searchPaymentByOrderIdInputPort;
  private final ApprovePaymentInputPort approvePaymentInputPort;


  @GetMapping("/orders/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public PaymentResponse getPaymentByOrderId(@NotNull @PathVariable final Integer orderId) {
    log.info("Payment search by orderId {} ", orderId);
    var payment = searchPaymentByOrderIdInputPort.execute(orderId);
    return modelMapper.map(payment, PaymentResponse.class);
  }

  @PatchMapping("/{paymentId}")
  @ResponseStatus(HttpStatus.OK)
  public PaymentResponse paymentApproval(@NotNull @PathVariable final Integer paymentId) {
    log.info("Payment approval for paymentId: {} received", paymentId);
    return modelMapper.map(approvePaymentInputPort.execute(paymentId), PaymentResponse.class);
  }
}
