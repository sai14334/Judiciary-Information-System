/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;


import Beans.Cases;
import Beans.Registrar;
import DaoClasses.AcknowledgmentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "AcknowledgementServlet", urlPatterns = {"/sendacknowledgment"})
public class AcknowledgmentServlet extends HttpServlet {

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
            AcknowledgmentDao ad = new AcknowledgmentDao();
            List<Cases> list = reg.getUpcomingCaseDetails();
            boolean flag=false;
            if(list != null){
                flag = ad.addAckDetails(list);
                System.out.println(flag +" from servlet");
                if(flag){
                    request.setAttribute("AckSent", "Acknowledgments Sent to All Stations Based on Hearing Dates");
                    request.getRequestDispatcher("confirm.jsp").include(request, response);
                }
                else{
                    request.setAttribute("AckFailed", "Unable to Send Acknowledgemet Try Again!!!");
                    request.getRequestDispatcher("error.jsp").include(request, response);
                }
            }
            else{
            request.setAttribute("Ackerror", "Unable to find Upcoming Case Details");
            request.getRequestDispatcher("error.jsp").include(request, response);
            }
    }
}
