/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.beans.Cases;
import com.uprooters.beans.Judge;
import com.uprooters.daoclasses.AssignedCasesDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "ViewAssignedCasesServlet", urlPatterns = {"/viewassignedcases"})
public class ViewAssignedCasesServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        AssignedCasesDao acd = new AssignedCasesDao();
        Judge jud = new Judge();
        int id = acd.getJudgeId(username);
        if(id>0){
            List<Cases> cases = jud.viewAssignedCases(id);
            request.setAttribute("list", cases);
            request.getRequestDispatcher("ViewAssignedCases.jsp").include(request, response);
            
        }
        else{
            request.setAttribute("error", "Session Expired!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        
    }
}
