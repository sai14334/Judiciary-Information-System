/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DaoClasses.LoginDao;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet 
{
    /**
     * doPost method process all post requests 
     * 
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        LoginDao lDao= new LoginDao();
        String userType = request.getParameter("user");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        int isValid = lDao.checkValidity(userType,userName,password);
        System.out.println(userName+" "+password+"From Servlet");
        HttpSession session =request.getSession();
        session.setAttribute("username", userName);
        switch (isValid) {
            case 1 -> response.sendRedirect("Registrar.jsp");
            case 2 -> response.sendRedirect("Lawyer.jsp");
            case 3 -> response.sendRedirect("Judge.jsp");
            case 4 -> response.sendRedirect("Station.jsp");
            default -> {
                response.setContentType("text/html");
                PrintWriter out= response.getWriter();
                request.setAttribute("errorMessage", "Wrong Credentials Provided");
                RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
            
    }
}
