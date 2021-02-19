package com.example.JspForm;

import com.example.JspForm.database.Customer;
import com.example.JspForm.database.JDBCExecutor;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloIndex", value = "/index")
public class Index extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {









    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");




        RequestDispatcher dispatcher=request.getRequestDispatcher("/html/index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}