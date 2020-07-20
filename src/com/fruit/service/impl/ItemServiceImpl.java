package com.fruit.service.impl;

import com.fruit.dao.ItemDao;
import com.fruit.dao.impl.ItemDaoImpl;
import com.fruit.pojo.Item;
import com.fruit.pojo.Page;
import com.fruit.service.ItemService;

import java.awt.print.Book;
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

    @Override
    public Page<Item> page(Integer pageNo, Integer pageSize) {
        Page<Item> page = new Page<Item>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = itemDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }

        pageNo = (pageNo>pageTotal)?pageTotal:pageNo;
        page.setPageNo(pageNo);
        page.setPageTotal(pageTotal);

        //当前页的开始索引
        int begin=(pageNo-1) * pageSize;
        List<Item> items = itemDao.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }
}
