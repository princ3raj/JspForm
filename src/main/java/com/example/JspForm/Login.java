package com.example.JspForm;

import com.example.JspForm.database.Customer;
import com.example.JspForm.database.JDBCExecutor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/login")
public class Login extends HttpServlet {

    private Integer hitCount;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter writer=resp.getWriter();


        System.out.println("Client ip address"+req.getRemoteAddr());
        System.out.println(req.getRequestURL());

        Cookie[] cookies = req.getCookies();


        for(int i=0;i<cookies.length;i++)
            if(cookies[i].getName().equals("logged_in")) {



                String logged_in_value=cookies[i].getValue();

                if(logged_in_value.equals("1")){


                    RequestDispatcher dispatcher=req.getRequestDispatcher("/html/index.jsp");
                    try {
                        dispatcher.forward(req,resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }


                }




            }

        boolean found = false;
        if(cookies != null)
            for(int i=0;i<cookies.length;i++)
                if(cookies[i].getName().equals("session_started")) {
                    String hit=cookies[i].getValue();
                    hitCount=Integer.parseInt(hit);
                    hitCount++;
                    String dt=Integer.toString(hitCount);
                    resp.addCookie(new Cookie("session_started", dt));
                    found = true;
                    System.out.println("Welcome to our site..."+"hit Count: "+dt);
                    writer.println("<footer>Welcome to our site..."+"hit Count: "+dt+"</footer>");

                }
        if(!found) {
            String dt ="1";
            resp.addCookie(new Cookie("session_started", dt));
            System.out.println("Welcome to outr site..."+"hit Count: "+dt);
        }



        RequestDispatcher dispatcher=req.getRequestDispatcher("/html/login.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("logged_in", "1");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        String username=req.getParameter("username");
        String password=req.getParameter("password");


        Customer customer= JDBCExecutor.LoginOnDataBase(username,password);

        if (username.equals(customer.getEmail())){



            RequestDispatcher dispatcher=req.getRequestDispatcher("/html/index.jsp");
            try {
                dispatcher.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            }



        }else{
            resp.getWriter().write("<html><h1>Wrong Credentials</h1></html>");
        }



    }
}
