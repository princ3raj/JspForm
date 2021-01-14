package com.example.JspForm;

import com.example.JspForm.database.Customer;
import com.example.JspForm.database.JDBCExecutor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher=req.getRequestDispatcher("/html/login.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username=req.getParameter("username");
        String password=req.getParameter("password");


        Customer customer= JDBCExecutor.LoginOnDataBase(username,password);

        if (username.equals(customer.getEmail())){

            resp.getWriter().write("<html><h1>Welcome "+customer.getFirstName()+" "+customer.getLastName()+"</h1><html>");

        }else{
            resp.getWriter().write("<html><h1>Wrong Credentials</h1></html>");
        }



    }
}
