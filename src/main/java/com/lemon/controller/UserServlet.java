package com.lemon.controller;

import com.lemon.pojp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    List<User> list = null;

    public UserServlet() {
        list = new ArrayList<>();
        list.add(new User(1, "zs", "666"));
        list.add(new User(1, "ls", "888"));
        list.add(new User(1, "ww", "999"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("login".equals(action)){
            login(request, response);
        }else if ("findAll".equals(action)){
            findAll(request, response);
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userPwd = request.getParameter("pwd");
        boolean b = false;
        for (User user: list){
            if (user.getUserName().equals(username) && user.getUserPwd().equals(userPwd)){
                b = true;
            }
        }
        if(b){
            //服务器内部转换，同一请求，地址栏不会发生变化，登陆成功后，将用户信息放入session值域
            request.getSession().setAttribute("user", new User(username, userPwd));
            //登陆成功记住密码，存放到cookie
            Cookie c = new Cookie("username", username);
            c.setMaxAge(1*24*60*60); //最大过期时间，以秒为单位   没有这句话就是内存的cookie，有的话就是持久在硬盘上
            response.addCookie(c);
            //从一个控制层到另一个控制层
            PrintWriter out = response.getWriter();
            String str = "{\"data\":\"ok\",\"status\":\"1\"}";
            out.println(str);
            out.flush();
            //request.getRequestDispatcher("UserServlet?action=findAll").forward(request, response);
        }else {
            //重定向，第二次请求，地址栏发生变化
            PrintWriter out = response.getWriter();
            String str = "{\"data\":\"error\",\"status\":\"0\"}";
            out.println(str);
            out.flush();
            //response.sendRedirect("login.jsp?msg=error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
