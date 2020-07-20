package com.fruit.test;

import com.fruit.pojo.Page;
import com.fruit.service.ItemService;
import com.fruit.service.impl.ItemServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 11:47 pm 18/7/20
 */
public class ItemServiceTest {
    private ItemService itemService = new ItemServiceImpl();
    @Test
    public void addItem() {
//        itemService.addItem();
    }

    @Test
    public void deleteItemById() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void queryItemById() {
    }

    @Test
    public void queryItems() {
    }
    @Test
    public void page(){
        System.out.println(itemService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){
        System.out.println(itemService.pageByPrice(1, Page.PAGE_SIZE,0,10));
    }
}