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

/**
 * @author : Xin Tian
 * @date : 5:00 pm 20/7/20
 */
public class ClientItemServlet extends BaseServlet {

    private ItemService itemService = new ItemServiceImpl();
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

        page.setUrl("client/itemServlet?action=page");
//        3、保存到Request域中
        req.setAttribute("page", page);
//        4、请求转发到item_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
//        2、调用ItemService.page(pageNo, pageSize)方法,得到Page对象
        Page<Item> page = itemService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder stringBuilder = new StringBuilder("client/itemServlet?action=pageByPrice");
        if (req.getParameter("min") != null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
//        page.setUrl("client/itemServlet?action=pageByPrice&min="+min+"&max="+max);
        page.setUrl(stringBuilder.toString());
//        3、保存到Request域中
        req.setAttribute("page", page);
//        4、请求转发到item_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
