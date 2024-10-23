/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Cases;
import Beans.Judge;
import DaoClasses.AssignedCasesDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "JudgeCasesSortServlet", urlPatterns = {"/viewsortjudge"})
public class JudgeCasesSortServlet extends HttpServlet {

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
        String sortBy = request.getParameter("sortBy");
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("username");
        AssignedCasesDao ad = new AssignedCasesDao();
        Judge jud = new Judge();
        if(uname != null){
                int id = ad.getJudgeId(uname);
                List<Cases> list = jud.viewAssignedCases(id);
                if(list != null){
                    if("hearingDate".equals(sortBy)){
                        System.out.println("Hearing Date Fetched");
                        Collections.sort(list, new Comparator<Cases>(){
                         @Override
                        public int compare(Cases c1, Cases c2){
                            if(c1.getHearingDate() == null && c2.getHearingDate() == null){
                                return 0;
                            }
                            if(c1.getHearingDate() == null){
                                return -1;
                            }
                            if(c2.getHearingDate() == null){
                                return 1;
                            }
                           return c1.getHearingDate().compareTo(c2.getHearingDate());
                        } 
                    });
                    }
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("ViewAssignedCases.jsp").include(request, response);
                }else{
                    request.setAttribute("error", "Unable to retrive data!!!!");
                    request.getRequestDispatcher("error.jsp").include(request, response);
                }
        }
        else{
            request.setAttribute("error", "Session Expired!!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
    }
}
