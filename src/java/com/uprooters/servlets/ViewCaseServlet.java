/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.beans.Cases;
import com.uprooters.beans.Registrar;
import com.uprooters.daoclasses.JudgementDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "ViewCaseServlet", urlPatterns = {"/viewcase"})
public class ViewCaseServlet extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("caseid"));
        JudgementDao jd = new JudgementDao();
        Date date = jd.closeCase(id);
        Cases cases = reg.getCaseById(id);
       if(cases.getCaseId() != 0){
        if(cases != null){
            cases.setEndDate(date);
            request.setAttribute("Case", cases);
            request.getRequestDispatcher("ViewACase.jsp").include(request, response);
        }
        else{
            request.setAttribute("unabletoview", "Unable to View Case Details !!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
           
        }
       }
       else{
           request.setAttribute("unabletoview", "No Case found!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
       }
    }
}
