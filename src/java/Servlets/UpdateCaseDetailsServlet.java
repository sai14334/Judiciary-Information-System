/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Registrar;
import DaoClasses.UpdateCaseDetailsDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "UpdateCaseDetailsServlet", urlPatterns = {"/updateCase"})
public class UpdateCaseDetailsServlet extends HttpServlet {

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
    Registrar reg = new Registrar();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    UpdateCaseDetailsDao ucd = new UpdateCaseDetailsDao();
    // Parse the caseId from request
    int caseid = Integer.parseInt(request.getParameter("caseId"));
   // String caseStatus = request.getParameter("caseStatus");
    String caseSummary = request.getParameter("caseSummary");
    
    // Variables to hold parsed dates
    Date hearingdate = null;
   // Date endDate = null;

    try {
        // Parse the hearing date
        hearingdate = formatter.parse(request.getParameter("hearingDate"));
        
        // Check if endDate is provided and parse it
//        String endDateParam = request.getParameter("endDate");
//        if (endDateParam != null && !endDateParam.isEmpty()) {
//            endDate = formatter.parse(endDateParam);
//        }
    } catch (ParseException ex) {
        Logger.getLogger(UpdateCaseDetailsServlet.class.getName()).log(Level.SEVERE, "Date parsing error", ex);
        request.setAttribute("error", "Invalid date format provided.");
        request.getRequestDispatcher("UpdateCase.jsp").forward(request, response);
        return; // Exit if there's an error with date parsing
    }
    Date hrDate = ucd.getHearingDate(caseid);
    
    // Update case details based on whether endDate is provided
    boolean flag;
    if(hearingdate.after(hrDate)|| hearingdate.equals(hrDate)){
        //flag = reg.updateCaseDetails(caseid, caseStatus, caseSummary, hearingdate, endDate);
   
        flag = reg.updateCaseDetails(caseid, caseSummary, hearingdate);
    
        
    // Handle the result of the update
    if (flag) {
        request.setAttribute("success", "Data has been updated successfully!");
    } else {
        request.setAttribute("error", "Unable to update data or Judgement passed.");
    }
    
    // Forward the response back to UpdateCase.jsp
    request.getRequestDispatcher("UpdateCase.jsp?caseid="+caseid).forward(request, response);
    }
    else{
        request.setAttribute("error", "Provided Hearing Date is older than Existing Hearing Date");
        request.getRequestDispatcher("UpdateCase.jsp?caseid="+caseid).forward(request, response);
    }
}

}
