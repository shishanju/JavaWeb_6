package com.lemon.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class DemoListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("count", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(7);
        int count = (int) event.getSession().getServletContext().getAttribute("count");
        event.getSession().getServletContext().setAttribute("count", count+1);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        /*三种办法结束
                1.Url重写，每次请求获得一个新的session（session有效时间为30分钟，以秒为单位，实际1800秒）
                2.设置过期时间，调整过期时间
                event.getSession().setMaxInactiveInterval(7);
                3.立即过期*/
                //event.getSession().invalidate();
        int count = (int) e.getSession().getServletContext().getAttribute("count");
        e.getSession().getServletContext().setAttribute("count", count-1);
    }

}
