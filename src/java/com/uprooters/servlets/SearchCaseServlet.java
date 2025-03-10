/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.daoclasses.LawyerAssignedCasesDao;
import com.uprooters.daoclasses.PastCaseListDao;
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
@WebServlet(name = "SearchCaseServlet", urlPatterns = {"/searchcase"})
public class SearchCaseServlet extends HttpServlet {

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
        int caseid= Integer.parseInt(request.getParameter("caseid"));
        LawyerAssignedCasesDao lad = new LawyerAssignedCasesDao();
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("username");
        int lawid = lad.getLawyerId(uname);
        PastCaseListDao pcd = new PastCaseListDao();
        if(lawid != 0){
                boolean flag = lad.getAssignedCaseById(lawid, caseid);
                if(flag){
                    request.getRequestDispatcher("viewcase?caseid="+caseid).include(request, response);
                }
                else{
                    boolean status = lad.getUnClosedCases(caseid);
                    boolean check = lad.isExist(caseid);
                    if(status && check){    
                    request.getRequestDispatcher("viewcase?caseid="+caseid).forward(request, response);
                    }
                    else if( !check){
                         request.setAttribute("error", "Invalid Case ID!!!!!");
                        request.getRequestDispatcher("error.jsp").include(request, response);
                    }
                    else{
                        request.getRequestDispatcher("Payment.jsp").forward(request, response);
                    }
                }
        }
        else{
            request.setAttribute("error", "Session Expired !!!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        
    }
}
