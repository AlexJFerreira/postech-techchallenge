package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.PaymentRepository;
import br.com.postech.techchallenge.application.core.domain.Payment;
import br.com.postech.techchallenge.application.ports.out.SearchPaymentOutputPort;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchPaymentAdapter implements SearchPaymentOutputPort {

  private final PaymentRepository paymentRepository;
  private final ModelMapper modelMapper;

  @Override
  public Optional<Payment> execute(Integer orderId) {
    return paymentRepository.findByOrderId(orderId)
        .map(paymentEntity -> modelMapper.map(paymentEntity, Payment.class));
  }
}
