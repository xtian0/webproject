package com.fruit.service;

import com.fruit.pojo.Item;
import com.fruit.pojo.Page;

import java.util.List;

/**
 * @author : Xin Tian
 * @date : 11:42 pm 18/7/20
 */
public interface ItemService {
    void addItem(Item item);
    int deleteItemById(Integer id);
    int updateItem(Item item);
    Item queryItemById(Integer id);
    List<Item> queryItems();
    Page<Item> page(Integer pageNo, Integer pageSize);

    Page<Item> pageByPrice(int pageNo, int pageSize, int min, int max);
}
