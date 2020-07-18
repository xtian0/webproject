package com.fruit.service.impl;

import com.fruit.dao.ItemDao;
import com.fruit.dao.impl.ItemDaoImpl;
import com.fruit.pojo.Item;
import com.fruit.service.ItemService;

import java.util.List;

/**
 * @author : Xin Tian
 * @date : 11:44 pm 18/7/20
 */
public class ItemServiceImpl implements ItemService {
    private ItemDao itemDao = new ItemDaoImpl();
    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public int deleteItemById(Integer id) {
        return itemDao.deleteItemById(id);
    }

    @Override
    public int updateItem(Item item) {
        return itemDao.updateItem(item);
    }

    @Override
    public Item queryItemById(Integer id) {
        return itemDao.queryItemById(id);
    }

    @Override
    public List<Item> queryItems() {
        return itemDao.queryItems();
    }
}
