package com.example.JspForm;

import com.example.JspForm.database.Customer;
import com.example.JspForm.database.JDBCExecutor;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/register")
public class register extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String firstname=req.getParameter("firstname");
        String lastname=req.getParameter("lastname");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String address=req.getParameter("address");
        String city=req.getParameter("city");
        String state=req.getParameter("state");
        String zipcode=req.getParameter("zipcode");

        Customer customer=new Customer();
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setZipcode(zipcode);

       int i= JDBCExecutor.RegisterOnDataBase(customer);
       if (i==1){
           resp.getWriter().write("<html>Registered Successfully</html>");
       }






    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher=request.getRequestDispatcher("/html/login.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}