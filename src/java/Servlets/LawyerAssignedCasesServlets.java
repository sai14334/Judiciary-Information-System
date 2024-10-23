/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Cases;
import Beans.Lawyer;
import DaoClasses.LawyerAssignedCasesDao;
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
@WebServlet(name = "LawyerAssignedCasesServlets", urlPatterns = {"/viewmycases"})
public class LawyerAssignedCasesServlets extends HttpServlet {

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
        String uname = (String)session.getAttribute("username");
        LawyerAssignedCasesDao lad = new LawyerAssignedCasesDao();
        int lawyerId = lad.getLawyerId(uname);
        Lawyer law = new Lawyer();
        if(lawyerId>0){
            List<Cases> cases = law.getLawyerAssignedCases(lawyerId);
            if(cases != null){
                request.setAttribute("list", cases);
                request.getRequestDispatcher("ViewLawyerCases.jsp").include(request, response);
            }
            else{
                request.setAttribute("listerror", " No Assigned Cases Found");
                request.getRequestDispatcher("ViewLawyerCases.jsp").include(request, response);
            }
         }
        else{
            request.setAttribute("error", " Login Session Expired !! Please ReLogin and Try again");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        
    }
}
