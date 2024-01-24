package br.com.postech.techchallenge.dataprovider.database.repository;

import br.com.postech.techchallenge.dataprovider.database.entity.ItemEntity;
import br.com.postech.techchallenge.dataprovider.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
  void deleteAllByItem(ItemEntity itemEntity);

}
