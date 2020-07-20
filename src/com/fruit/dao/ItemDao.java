package com.fruit.dao;

import com.fruit.pojo.Item;

import java.util.List;

/**
 * @author : Xin Tian
 * @date : 10:51 pm 18/7/20
 */
public interface ItemDao {
    public int addItem(Item item);

    public int deleteItemById(Integer id);

    public int updateItem(Item item);

    public Item queryItemById(Integer id);

    public List<Item> queryItems();

    public Integer queryForPageTotalCount();
    public Integer queryForPageTotalCountByPrice(int min, int max);

    public List<Item> queryForPageItems(int begin, int pageSize);
    public List<Item> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
