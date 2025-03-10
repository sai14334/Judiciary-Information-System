/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uprooters.servlets;

import com.uprooters.daoclasses.LawyerPaymentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author rguktrkvalley
 */
@WebServlet(name = "LawyerPaymentServlet", urlPatterns = {"/payment"})
public class LawyerPaymentServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LawyerPaymentDao lpd = new LawyerPaymentDao();
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("username");
        String paymentStatus = request.getParameter("paymentStatus");  
        double amount = Double.parseDouble(request.getParameter("amount")); 
        boolean paymentSuccess = "success".equals(paymentStatus);
        int lawid = lpd.getLawyerId(uname);
        if(lawid>0){
            boolean status = lpd.addPaymentDetails(lawid, amount, paymentStatus);
            if(paymentSuccess && status ){              
                response.sendRedirect("PastCase.jsp");     
            }
            else if(paymentSuccess && !status){
                request.setAttribute("NotUpdated", "Payment Details not added! Try Again");
                request.getRequestDispatcher("Payment.jsp").include(request, response);
            }
            else{
                request.setAttribute("failed", "Payment Failed Try Again");
                request.getRequestDispatcher("Payment.jsp").include(request, response);
            }
        }
        else{
            request.setAttribute("error", "Session Expired Try Again");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        
        
    }

   

}
