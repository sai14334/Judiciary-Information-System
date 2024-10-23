/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.PaymentDetails;
import Beans.Registrar;
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
@WebServlet(name = "CheckPaymentsServlet", urlPatterns = {"/checkpaymet"})
public class CheckPaymentsServlet extends HttpServlet {

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
            int lawyerid = Integer.parseInt(request.getParameter("lawid"));
            Registrar reg = new Registrar();
            if(lawyerid>0){
                List<PaymentDetails> pd = reg.getPaymentDataById(lawyerid);
                if(pd != null){
                    request.setAttribute("PaymentList", pd);
                }
                else{
                    request.setAttribute("NoList", " Unable to Retrive Payment List");
                }
                request.getRequestDispatcher("PaymentList.jsp").include(request, response);
            }
            else{
                request.setAttribute("error", "InValid LawyerID");
                request.getRequestDispatcher("LawyerPayDetails.jsp").include(request, response);
            }
            
        
    }
}
