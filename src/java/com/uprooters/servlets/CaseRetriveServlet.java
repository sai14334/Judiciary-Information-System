/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.beans.Cases;
import com.uprooters.beans.Registrar;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "CaseRetriveServlet", urlPatterns = {"/registercase"})
public class CaseRetriveServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Registrar reg = new Registrar();
        List<Cases> list = reg.getUnregisteredDetails();
        if(list!=null){
            System.out.println("from servlets"+list);
            request.setAttribute("list", list);
            System.out.println(request.getAttribute("list")+"From servlets data list");
            request.getRequestDispatcher("DisplayCases.jsp").include(request, response);
        }
        else{
            request.setAttribute("retrivefailed", "Unable to retrive case plese try again!!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
            
        }
    }
}
