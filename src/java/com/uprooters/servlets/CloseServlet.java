/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.daoclasses.JudgementDao;
import com.uprooters.daoclasses.UpdateCaseDetailsDao;
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
@WebServlet(name = "CloseServlet", urlPatterns = {"/Close"})
public class CloseServlet extends HttpServlet {

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
        int caseid =Integer.parseInt(request.getParameter("caseid"));
        String caseStatus = "Closed";
        JudgementDao jd = new JudgementDao();
        Date endDate = jd.closeCase(caseid);
        UpdateCaseDetailsDao ucd = new UpdateCaseDetailsDao();
        boolean flag = ucd.isCaseClosed(caseid, caseStatus, endDate);
        if(flag)
            request.setAttribute("CaseClosed","Case Closed Successfully");
        else
            request.setAttribute("NotClosed", "Unable to Close Case");
        request.getRequestDispatcher("canclosecases").include(request, response);
        
    }
}
