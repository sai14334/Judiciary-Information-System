/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.beans.Registrar;
import com.uprooters.daoclasses.AddUserDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/adduser"})
public class AddUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       String type=request.getParameter("type");
       String username=request.getParameter("username");
       String pass=request.getParameter("password");
       String repass=request.getParameter("repass");
       String name=request.getParameter("name");
       String phone=request.getParameter("phone");
       String email = request.getParameter("email");
       Registrar reg = new Registrar();
       if(pass.equals(repass)){
           boolean flag = reg.addUser(type,username,pass,name,phone,email);
           if(flag){
               
               
               try {
                   request.setAttribute("UserAdded", "User Details Added Successfully !!!!");
                   request.getRequestDispatcher("confirm.jsp").include(request, response);
               } catch (ServletException ex) {
                   Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
           else{
               try {
                   request.setAttribute("UserNotAdded", "User Details adding Failed!!! or Duplicate Entry");
                   request.getRequestDispatcher("error.jsp").include(request, response);
               } catch (ServletException ex) {
                   Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
        }
       else{
           
           try {request.setAttribute("Failed", "Passwords Should Match !!!!");
               request.getRequestDispatcher("addUser.jsp").include(request, response);
           } catch (ServletException ex) {
               Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    }

  
}
