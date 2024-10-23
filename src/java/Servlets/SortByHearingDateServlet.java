/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Cases;
import Beans.Lawyer;
import Beans.Registrar;
import DaoClasses.AssignedCasesDao;
import DaoClasses.LawyerAssignedCasesDao;
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
@WebServlet(name = "SortByHearingDateServlet", urlPatterns = {"/viewsortcases"})
public class SortByHearingDateServlet extends HttpServlet {

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
        AssignedCasesDao ad = new AssignedCasesDao();
        List<Cases> list = reg.getAllCases();
        String sortBy = request.getParameter("sortBy");
        String from = request.getParameter("from");
        if(from == null){
        if("hearingDate".equals(sortBy)){
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
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("username");
        if(uname != null){
            int judgeid = ad.getJudgeId(uname);
            if(judgeid>0){
              request.setAttribute("list", list);
              request.setAttribute("access", "Judge");
              request.getRequestDispatcher("ViewAllCases.jsp").include(request, response);
            }
            else{
                request.setAttribute("list", list);
              request.getRequestDispatcher("ViewAllCases.jsp").include(request, response);
            }
        }else{
            request.setAttribute("error", "Session Expired!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
    }
        else{
            Lawyer lawyer = new Lawyer();
            HttpSession session = request.getSession();
            String uname = (String)session.getAttribute("username");
            if(uname != null){
                LawyerAssignedCasesDao lad = new LawyerAssignedCasesDao();
            int  id =  lad.getLawyerId(uname);
            List<Cases> listcase = lawyer.getLawyerAssignedCases(id);
                if("hearingDate".equals(sortBy)){
            Collections.sort(listcase, new Comparator<Cases>(){
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
                request.setAttribute("list", listcase);
                request.getRequestDispatcher("ViewLawyerCases.jsp").include(request, response);
            }
            else{
                request.setAttribute("error", "Session Expired!!!");
                request.getRequestDispatcher("error.jsp").include(request, response);
            }
        }
    }
}
