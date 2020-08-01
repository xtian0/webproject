package com.fruit.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : Xin Tian
 * @date : 12:09 pm 22/7/20
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;

    /**
     * key: 商品编号
     * value: 商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Cart() {
    }


    /**
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
//        check if item is already in cart
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            //not added
            items.put(cartItem.getId(), cartItem);
        } else{
            //already added
            item.setCount(item.getCount()+1); //update count
            item.setTotalPrice( item.getPrice().multiply(new BigDecimal(item.getCount()))); //update total price
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clean(){
        items.clear();
    }

    public void updateCount(Integer id, Integer count){
        CartItem item = items.get(id);
        if (item != null){
            //already added
            item.setCount(count); //修改商品数量
            item.setTotalPrice( item.getPrice().multiply(new BigDecimal(item.getCount()))); //update total price

        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
//        for (CartItem value : items.values()) {
//
//        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

}
