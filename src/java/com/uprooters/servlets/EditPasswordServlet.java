/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.daoclasses.EditPasswordDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "EditPasswordServlet", urlPatterns = {"/editpassword"})
public class EditPasswordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String repass = request.getParameter("repass");
        String usertype = request.getParameter("user");
        EditPasswordDao epd = new EditPasswordDao();
        if(newpass.equals(repass)){
           boolean flag =  epd.checkOldPassowrd(usertype, username, oldpass);
           if(flag){
               boolean status = epd.updatePassword(username, newpass, usertype);
               if(status)
                   request.setAttribute("success", "Password Updated Successfully");
               else
                   request.setAttribute("error", "Unable to Update Passowrd");
           }
           else{
               request.setAttribute("oldpasserror", "Incorrect Old Password Provided or Session Expired");
           }
        }
        else{
            request.setAttribute("newpasserror", "New Password Mismatched Try Again");
        }
        request.getRequestDispatcher("EditPassword.jsp").include(request, response);
    }
}
