/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.beans.Cases;
import com.uprooters.beans.Judge;
import com.uprooters.daoclasses.AssignedCasesDao;
import com.uprooters.daoclasses.JudgementDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "JudgementServlet", urlPatterns = {"/judgement"})
public class JudgementServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        JudgementDao jd = new JudgementDao();
        String judgedesc = request.getParameter("judgedesc");  
        int caseid = Integer.parseInt(request.getParameter("caseId"));
        Date judgedate = null;
        try {
            String dateParam = request.getParameter("judgedate");
            if (dateParam != null && !dateParam.isEmpty()) {
                judgedate = formatter.parse(dateParam);
            } else {
                // If judgedate is not provided, handle it gracefully
                request.setAttribute("judgementerror", "Judgment date is required.");
                request.getRequestDispatcher("ViewAssignedCases.jsp").include(request, response);
                return; // Exit early if there's a validation issue
        }
    } catch (ParseException ex) {
        Logger.getLogger(JudgementServlet.class.getName()).log(Level.SEVERE, null, ex);
        request.setAttribute("judgementerror", "Invalid judgment date format.");
        request.getRequestDispatcher("ViewAssignedCases.jsp").include(request, response);
        return; // Exit early on parse exception
    } 
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        
        AssignedCasesDao acd = new AssignedCasesDao();
        Judge jud = new Judge();
        if(username!=null){
        int id = acd.getJudgeId(username);
        System.out.println("UserName from Judgement"+username);
        List<Cases> cases = jud.viewAssignedCases(id);
        System.out.println("Judgement id"+id);
        Date exDate = jd.getHearingDate(caseid);
        if(exDate.before(judgedate) || exDate.equals(judgedate)){
        boolean flag = jud.makeJudgement(caseid, judgedesc, id, judgedate);
        if(flag){
            //request.setAttribute("completed"+caseid, true);
            request.setAttribute("Success", "Judgement Details Updated Successfully");
            request.setAttribute("list", cases);
        }
        else{
            request.setAttribute("judgementerror", "Something went wrong!! Judgement Details not Updated");
            request.setAttribute("list", cases);
        }
        request.getRequestDispatcher("ViewAssignedCases.jsp").include(request, response);
        }
        else{
            request.setAttribute("dateerror", "Judgement date must be on or after Last Hearing Date");
            request.getRequestDispatcher("PassJudgement.jsp?caseid="+caseid).include(request, response);
        }
        }
        else{
            request.setAttribute("error", "Session Expired!!!!!");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
    }
}
