package com.fruit.web;

import com.fruit.pojo.Item;
import com.fruit.pojo.Page;
import com.fruit.service.ItemService;
import com.fruit.service.impl.ItemServiceImpl;
import com.fruit.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : Xin Tian
 * @date : 12:56 pm 19/7/20
 */
public class ItemServlet extends BaseServlet {

    private ItemService itemService = new ItemServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo += 1;
        Item item = WebUtils.copyParaToBean(req.getParameterMap(),new Item());
        itemService.addItem(item);
        //重定向发送两次请求，不共享request域
        resp.sendRedirect(req.getContextPath()+"/manager/itemServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        itemService.deleteItemById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/itemServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        req.setAttribute("item", itemService.queryItemById(id));
        req.getRequestDispatcher("/pages/manager/item_edit.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = WebUtils.copyParaToBean(req.getParameterMap(), new Item());
        itemService.updateItem(item);
        resp.sendRedirect(req.getContextPath()+"/manager/itemServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = itemService.queryItems();
        req.setAttribute("items", items);
        req.getRequestDispatcher("/pages/manager/item_manager.jsp").forward(req, resp);
    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
//        2、调用ItemService.page(pageNo, pageSize)方法,得到Page对象
        Page<Item> page = itemService.page(pageNo,pageSize);

        page.setUrl("manager/itemServlet?action=page");
//        3、保存到Request域中
        req.setAttribute("page", page);
//        4、请求转发到item_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/item_manager.jsp").forward(req, resp);
    }
}
