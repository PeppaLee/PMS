package com.pms.action;

import com.alibaba.fastjson.JSON;
import com.pms.commons.ResResult;
import com.pms.commons.SpringIOC;
import com.pms.dao.pojo.User;
import com.pms.service.iservice.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserLoginServlet", urlPatterns = {"/UserLoginServlet"})
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        IUserService userService = (IUserService) SpringIOC.getCtx().getBean("userService");

        ResResult<User> rr = userService.login(username, password);
//        if(username.equals(rr.getData().getUsername())&&password.equals(rr.getData().getPassword())){
//                 rr.setCode(200);
//        }else{
//            rr.setCode(404);
//        }
//        if (rr != null) {
//            rr = new ResResult<User>(200,"login success");
//        }else{
//            rr = new ResResult<User>(404,"login error");
//        }

        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(rr));
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
