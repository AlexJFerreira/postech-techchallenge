package br.com.postech.techchallenge.dataprovider.database;

import br.com.postech.techchallenge.core.dataprovider.database.ItemDataProvider;
import br.com.postech.techchallenge.core.domain.Item;
import br.com.postech.techchallenge.core.domain.enums.ItemType;
import br.com.postech.techchallenge.dataprovider.database.entity.ItemEntity;
import br.com.postech.techchallenge.dataprovider.database.repository.ItemRepository;
import br.com.postech.techchallenge.dataprovider.database.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemDataProviderImpl implements ItemDataProvider {

  private final ItemRepository itemRepository;
  private final OrderItemRepository orderItemRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public Item registerItem(Item item) {
    var itemEntity = modelMapper.map(item, ItemEntity.class);
    return modelMapper.map(itemRepository.save(itemEntity), Item.class);
  }

  @Override
  @Transactional
  public void deleteItemById(Integer id) {
    var item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    orderItemRepository.deleteAllByItem(item);
    itemRepository.delete(item);
  }

  @Override
  @Transactional
  public Item editItem(Integer id, Item item) {
    var itemEntity = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    modelMapper.map(item, itemEntity);
    return modelMapper.map(itemRepository.save(itemEntity), Item.class);
  }

  @Override
  @Transactional
  public List<Item> searchItemByType(ItemType type) {
    var items = itemRepository.findByType(type);
    return items.stream()
        .map(itemEntity -> modelMapper.map(itemEntity, Item.class))
        .toList();
  }
}
