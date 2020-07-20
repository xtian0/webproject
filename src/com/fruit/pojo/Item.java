package com.fruit.pojo;

/**
 * @author : Xin Tian
 * @date : 10:40 pm 18/7/20
 */
public class Item {
    private Integer id;
    private String name;
    private Double price;
    private String place;
    private Integer sales;
    private Integer stock;
    private String img_path = "static/img/default.jpg";

    public Item() {
    }

    public Item(Integer id, String name, Double price, String place, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.place = place;
        this.sales = sales;
        this.stock = stock;

        //要求给定的图片路径不能为空
        if (img_path!=null && !img_path.equals("")){
            this.img_path = img_path;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
//        要求给定的图片路径不能为空
        if (img_path!=null && !img_path.equals("")){
            this.img_path = img_path;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", place='" + place + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
