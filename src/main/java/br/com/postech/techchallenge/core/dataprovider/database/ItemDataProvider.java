package br.com.postech.techchallenge.core.dataprovider.database;

import br.com.postech.techchallenge.core.domain.Item;
import br.com.postech.techchallenge.core.domain.enums.ItemType;
import java.util.List;

public interface ItemDataProvider {
  Item registerItem(Item item);

  void deleteItemById(Integer id);

  Item editItem(Integer id, Item item);

  List<Item> searchItemByType(ItemType type);

}
