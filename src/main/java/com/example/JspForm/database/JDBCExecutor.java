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


            //update Data from Database
//                Customer customer=customerDAO.findById(10000);
//                System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
//                customer.setEmail("update it yet");
//                customer.setFirstName("Kartik");
//                customer.setLastName("Goel");
//                customer=customerDAO.update(customer);
//                System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());

//                //Read
//                Customer customer1=customerDAO.findById(1000);
//                System.out.println(customer1.getFirstName()+" "+customer1.getLastName());

//            //Insert
//            Customer customer2=new Customer();
//            customer2.setFirstName("Prince");
//            customer2.setLastName("Raj");
//            customer2.setEmail("prince@123gmail.com");
//            customer2.setPhone("9602723097");
//            customer2.setAddress("Delhi");
//            customer2.setCity("Noida");
//            customer2.setState("Delhi");
//            customer2.setZipcode("201303");


            customerDAO.create(customer);

//                //Read again
//                Customer customer3=customerDAO.findById(10005);
//                System.out.println(customer3.getFirstName()+customer3.getLastName());





        }catch (SQLException e){

            e.printStackTrace();

        }

        return 1;






    }





    }

