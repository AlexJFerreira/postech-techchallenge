package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.entity.PaymentEntity;
import br.com.postech.techchallenge.adapters.out.database.repository.PaymentRepository;
import br.com.postech.techchallenge.application.core.domain.Payment;
import br.com.postech.techchallenge.application.ports.out.ApprovePaymentOutputPort;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApprovePaymentAdapter implements ApprovePaymentOutputPort {

  private final PaymentRepository paymentRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public Optional<Payment> execute(Integer paymentId) {
    Optional<PaymentEntity> payment = paymentRepository.findById(paymentId);
    payment.ifPresent(PaymentEntity::approve);
    return payment.map(paymentEntity -> modelMapper.map(paymentEntity, Payment.class));
  }
}
