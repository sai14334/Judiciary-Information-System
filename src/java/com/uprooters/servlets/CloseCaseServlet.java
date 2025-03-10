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
@WebServlet(name = "CloseCaseServlet", urlPatterns = {"/canclosecases"})
public class CloseCaseServlet extends HttpServlet {

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
            List<Cases> cases = reg.closeCasesList();
            String closed = null;
            if(request.getAttribute("CaseClosed")!=null){
                 closed = (String)request.getAttribute("CaseClosed");
            }
            String notclosed = null;
            if(request.getAttribute("NotClosed")!=null){
                 notclosed = (String)request.getAttribute("NotClosed");
            }
            if(cases!=null){
                request.setAttribute("CaseClosed", closed);
                request.setAttribute("NotClosed",notclosed);
                request.setAttribute("list", cases);
            }
            else
                request.setAttribute("error", "unable to retrive ready to close cases");
            request.getRequestDispatcher("ClosingCases.jsp").include(request, response);
    }
}
