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

@WebServlet(name = "UserExistServlet",urlPatterns = {"/UserUserExistServlet"})
public class UserExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        IUserService userService = (IUserService) SpringIOC.getCtx().getBean("userService");
        String msg = userService.userExist(username);
        PrintWriter out = response.getWriter();
        ResResult<User> rr = null;
        if(msg.indexOf("success")!=-1){
            rr = new ResResult<User>(200,"find user");
        }else{
            rr = new ResResult<User>(404,"can not find user");
        }

        out.println(JSON.toJSONString(rr));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
