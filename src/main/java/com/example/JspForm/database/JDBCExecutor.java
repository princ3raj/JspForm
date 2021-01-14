package com.example.JspForm.database;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
    public static int RegisterOnDataBase(Customer customer){
        try {
            System.out.println("start running");
            DatabaseConnectionManager dcm= new DatabaseConnectionManager("localhost","hplussport","postgres","");
            Connection connection= dcm.getConnection();
            CustomerDAO customerDAO=new CustomerDAO(connection);
            customerDAO.create(customer);
        }catch (SQLException e){

            e.printStackTrace();

        }
        return 1;

    }



    public static Customer LoginOnDataBase(String username,String password){
        Customer customer=null;
        try {
            System.out.println("start running");
            DatabaseConnectionManager dcm= new DatabaseConnectionManager("localhost","hplussport","postgres","");
            Connection connection= dcm.getConnection();
            CustomerDAO customerDAO=new CustomerDAO(connection);
            customer= customerDAO.getUser(username,password);
        }catch (SQLException e){

            e.printStackTrace();

        }
        return customer;

    }




    }

