/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DaoClasses.CaseRegstrationDao;
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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "CaseRegisterServlet", urlPatterns = {"/register"})
public class CaseRegisterServlet extends HttpServlet {

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
             CaseRegstrationDao registerDao= new CaseRegstrationDao();
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String defName = request.getParameter("defName");
            String defAddress=request.getParameter("defAddress");
            String crimeType = request.getParameter("crimeType");
            Date crimeDate=null, arrestDate=null,startDate=null;
            HttpSession session =request.getSession();
            
           String uname = (String)session.getAttribute("username");
           System.out.println("session value "+uname);
          if(uname !=null){
            int stationid = registerDao.getStationId(uname);
        try {
             crimeDate = formatter.parse(request.getParameter("crimeDate"));
        } catch (ParseException ex) {
            Logger.getLogger(CaseRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String crimeLoc = request.getParameter("crimeLoc");
        String officerName=request.getParameter("officerName");
        try {
             arrestDate = formatter.parse(request.getParameter("arrestDate"));
        } catch (ParseException ex) {
            Logger.getLogger(CaseRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            startDate = formatter.parse(request.getParameter("startDate"));
        } catch (ParseException ex) {
            Logger.getLogger(CaseRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   
         Date curr = new Date();
         curr= clearTime(curr);
         //String lawyerName=request.getParameter("lawyerName");
         String caseSummary= request.getParameter("summary");
         if((crimeDate.before(curr)|| crimeDate.equals(curr)) && 
                 (arrestDate.after(crimeDate)|| arrestDate.equals(crimeDate)) && 
                (startDate.after(arrestDate) || startDate.after(arrestDate)) &&
                 (arrestDate.before(curr) || arrestDate.equals(curr)) &&
                 (startDate.before(curr) || startDate.equals(curr))){
           boolean status=registerDao.isRegistered(defName,defAddress,crimeType,crimeDate,crimeLoc,officerName,arrestDate,startDate,caseSummary, stationid);
           if(status){
               request.setAttribute("Registered", "Case Registration Successufully Completed!!!!");
               request.getRequestDispatcher("confirm.jsp").include(request, response);
           }
           else{
               request.setAttribute("Unregister", "Case Registration Failed Try Again!!!/Session Expired");
                request.getRequestDispatcher("CaseRegister.jsp").include(request, response);
               
           }
         }
         else{
             String illegal = "Crime Date must be less than or equal to today\n Arrest Date must be after or equal to Crime date\nCase Start Date should be after or equal to Arrest Date!!!";
             request.setAttribute("Illegal",illegal);
                request.getRequestDispatcher("error.jsp").include(request, response);
        }
        }
          else{
              request.setAttribute("error", "Session Expired!!!!!");
                request.getRequestDispatcher("error.jsp").include(request, response);
          }
    }
        public Date clearTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
      
    }


