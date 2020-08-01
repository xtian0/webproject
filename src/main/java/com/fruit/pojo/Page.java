package com.fruit.pojo;

import java.util.List;

/**
 * @author : Xin Tian
 * @date : 10:45 pm 19/7/20
 */

/**
 * Page：分页模块对象
 * @param <T> 具体的JavaBean
 */
public class Page<T> {
    public static final Integer PAGE_SIZE=4;
    private Integer pageNo;
    private Integer pageTotal;
    private Integer pageTotalCount;
    private Integer pageSize = PAGE_SIZE;
    private List<Item> items;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageTotalCount, List<Item> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
