package com.fruit.dao.impl;

import com.fruit.dao.BaseDao;
import com.fruit.dao.ItemDao;
import com.fruit.pojo.Item;

import java.util.List;

/**
 * @author : Xin Tian
 * @date : 10:55 pm 18/7/20
 */
public class ItemDaoImpl extends BaseDao implements ItemDao {
    @Override
    public int addItem(Item item) {
        String sql = "insert into item(name, price, place, sales, stock, img_path)values(?,?,?,?,?,?)";
        return update(sql,item.getName(),item.getPrice(),item.getPlace(),item.getSales(),item.getStock(),item.getImg_path());
    }

    @Override
    public int deleteItemById(Integer id) {
        String sql = "delete from item where id = ?";
        return update(sql,id);

    }

    @Override
    public int updateItem(Item item) {
        String sql = "update item set name=?, price=?, place=?, sales=?, stock=?, img_path=? where id = ?";
        return update(sql, item.getName(),item.getPrice(),item.getPlace(),item.getSales(),item.getStock(),item.getImg_path(),item.getId());
    }

    @Override
    public Item queryItemById(Integer id) {
        String sql = "select id, name, price, place, sales, stock, img_path from item where id = ? ";
        return queryForOne(Item.class, sql, id);
    }

    @Override
    public List<Item> queryItems() {
        String sql = "select id, name, price, place, sales, stock, img_path from item";
        return queryForlist(Item.class, sql);
    }
}
