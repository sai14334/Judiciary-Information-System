/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.daoclasses.CaseRegstrationDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "StationCaseSearch", urlPatterns = {"/viewstcases"})
public class StationCaseSearch extends HttpServlet {

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
            HttpSession session = request.getSession();
            String uname = (String)session.getAttribute("username");
            CaseRegstrationDao crd = new CaseRegstrationDao();
            if(uname != null){
                int sid = crd.getStationId(uname);
                    boolean status = crd.isStationCase(sid, caseid);
                    if(status){
                        System.out.println("inside search case station");
                        request.getRequestDispatcher("viewcase?caseid="+caseid).forward(request, response);
                    }
                    else{
                        request.setAttribute("error", " Cannot View Other Station Cases or Invalid Case Number");
                        request.getRequestDispatcher("error.jsp").include(request, response);
                    }
            } 
            else{
                request.setAttribute("error", "Session Expired");
                request.getRequestDispatcher("error.jsp").include(request, response);
            }
    }
}
