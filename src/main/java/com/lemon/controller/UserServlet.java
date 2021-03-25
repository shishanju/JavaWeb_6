package com.lemon.controller;

import com.lemon.pojp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("login".equals(action)){
            login(request, response);
        }else if ("findAll".equals("action")){
            findAll(request, response);
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "zs", "666"));
        list.add(new User(1, "ls", "888"));
        list.add(new User(1, "ww", "999"));
        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userPwd = request.getParameter("pwd");
        boolean b = false;
        if ("zs".equals(username) && "666".equals(userPwd)){
            b = true;
        }
        if(b){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            response.sendRedirect("login.jsp?msg=error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
