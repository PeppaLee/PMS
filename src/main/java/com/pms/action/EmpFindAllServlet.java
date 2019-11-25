package com.pms.action;

import com.alibaba.fastjson.JSON;
import com.pms.commons.SpringIOC;
import com.pms.dao.pojo.Emp;
import com.pms.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpFindAllServlet", urlPatterns = {"/EmpFindAllServlet"})
public class EmpFindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEmpService empService = (IEmpService) SpringIOC.getCtx().getBean("empService");
        List<Emp> empList = empService.findAll();

        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(empList));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
