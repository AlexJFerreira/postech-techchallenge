package br.com.postech.techchallenge.adapters.out.database.repository;

import br.com.postech.techchallenge.adapters.out.database.entity.PaymentEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
  Optional<PaymentEntity> findByOrderId(Integer orderId);
}
