package com.fruit.test;

import com.fruit.dao.ItemDao;
import com.fruit.dao.impl.ItemDaoImpl;
import com.fruit.pojo.Item;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 11:10 pm 18/7/20
 */
public class ItemDaoTest {
    ItemDao itemDao = new ItemDaoImpl();
    @Test
    public void addItem() {
        System.out.println(itemDao.addItem(new Item(null, "cherries", new BigDecimal(19.99),
                "New Zealand", 50, 100, "static/img/cherries.jpg")));
    }

    @Test
    public void deleteItemById() {
        itemDao.deleteItemById(11);
    }

    @Test
    public void updateItem() {
        System.out.println(itemDao.updateItem(new Item(12, "cherries", new BigDecimal(19.99),
                "New Zealand", 50, 105, "static/img/cherries.jpg")));
    }

    @Test
    public void queryItemById() {
        System.out.println(itemDao.queryItemById(12));
    }

    @Test
    public void queryItems() {
        for (Item queryItem : itemDao.queryItems()){
            System.out.println(queryItem);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(itemDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(itemDao.queryForPageItems(0,4));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(itemDao.queryForPageTotalCountByPrice(0, 10));
    }


    @Test
    public void queryForPageItemsByPrice() {
        for (Item queryItem : itemDao.queryForPageItemsByPrice(10, 4, 0, 10)){
            System.out.println(queryItem);
        }
    }
}