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
@WebServlet(name = "DeleteCase", urlPatterns = {"/deleteCase"})
public class DeleteCaseServlet extends HttpServlet {

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
        int caseid = Integer.parseInt(request.getParameter("caseid"));
        Registrar reg = new Registrar();
        boolean flag = reg.isCaseDeleted(caseid);
        if(flag)
            request.setAttribute("success", "Case Deleted Successfully!!!!");
        else
            request.setAttribute("error", "Unable to register case!!!!!");
        request.getRequestDispatcher("viewallcases").include(request, response);
    }
}
