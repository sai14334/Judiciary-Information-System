/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.beans.Registrar;
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
@WebServlet(name = "RemoveUserServlet", urlPatterns = {"/removeuser"})
public class RemoveUserServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String username = request.getParameter("username");
        Registrar reg = new Registrar();
        boolean flag = reg.removeUser(type,username);
        if(flag){
            request.setAttribute("userRemoved", "User Details deleted Successfully!!!");
            request.getRequestDispatcher("confirm.jsp").include(request, response);
            
        }
        else{
            request.setAttribute("failed", "Unable to delete User Details!!");
            request.getRequestDispatcher("removeUser.jsp").include(request, response);
        }
        
    }
}
