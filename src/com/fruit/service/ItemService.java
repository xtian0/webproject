package com.fruit.service;

import com.fruit.pojo.Item;

import java.util.List;

/**
 * @author : Xin Tian
 * @date : 11:42 pm 18/7/20
 */
public interface ItemService {
    public void addItem(Item item);
    public int deleteItemById(Integer id);
    public int updateItem(Item item);
    public Item queryItemById(Integer id);
    public List<Item> queryItems();
}
