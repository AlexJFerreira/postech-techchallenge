package br.com.postech.techchallenge.adapters.gateway.database.repository;

import br.com.postech.techchallenge.adapters.gateway.database.entity.OrderEntity;
import br.com.postech.techchallenge.core.domain.enums.OrderStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
  List<OrderEntity> findAllByStatusNot(OrderStatus status);
}
