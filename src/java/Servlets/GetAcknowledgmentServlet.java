/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Acknowledgment;

import Beans.Station;
import DaoClasses.CaseRegstrationDao;
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
@WebServlet(name = "GetAcknowledgmentServlet", urlPatterns = {"/showaknowledgments"})
public class GetAcknowledgmentServlet extends HttpServlet {

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
            Station st = new Station();
            CaseRegstrationDao crd = new CaseRegstrationDao();
            HttpSession session =request.getSession();
           String uname = (String)session.getAttribute("username");
           System.out.println("session value "+uname);
           if(uname != null){
          int stationid = crd.getStationId(uname);
            List<Acknowledgment> ack = st.getAcknowledgments(stationid);
            if(ack != null){
                request.setAttribute("AckList", ack);
                request.getRequestDispatcher("ViewAcknowledgments.jsp").include(request, response);
            }
            else{
                request.setAttribute("UnAckList", "Unable to retrive Acknowledge list");
                request.getRequestDispatcher("error.jsp").include(request, response);
            }
           }
           else{
               request.setAttribute("UnAckList", "Session Expired!!!!");
                request.getRequestDispatcher("error.jsp").include(request, response);
           }
    }
}
