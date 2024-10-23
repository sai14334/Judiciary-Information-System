/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Registrar;
import DaoClasses.AddLawyerJudgeDao;
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
@WebServlet(name = "AddJudgeLawyerServlet", urlPatterns = {"/assignJL"})
public class AddJudgeLawyerServlet extends HttpServlet {

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
        try {
            Registrar reg = new Registrar();
            AddLawyerJudgeDao ajd = new AddLawyerJudgeDao();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            int caseId = Integer.parseInt(request.getParameter("caseId"));
            int defId = Integer.parseInt(request.getParameter("lawyerId"));
            int ppId = Integer.parseInt(request.getParameter("PPId"));
            int judgeId = Integer.parseInt(request.getParameter("judgeId"));
            String lawyerName = request.getParameter("lawyerName");
            String PPName  = request.getParameter("PPName");
            String judgeName = request.getParameter("JudgeName");
            Date hearingdate = formatter.parse(request.getParameter("hearingdate"));
            Date verify = ajd.getStartDate(caseId);
            if(verify.before(hearingdate) || verify.equals(hearingdate)){
            if(defId != 0 && ppId!=0 && judgeId!=0 && defId!=ppId){
                boolean flag = reg.assignLawyerJudge(caseId, defId, ppId, judgeId, lawyerName, PPName, judgeName, hearingdate);
                if(flag){
                    request.setAttribute("confirm", "Details Updated Sucessfully!!!!");
                    request.getRequestDispatcher("addLawyerJudge.jsp").include(request, response);
                }
                else{
                    request.setAttribute("error", "an error Occured!!!!");
                    request.getRequestDispatcher("addLawyerJudge.jsp").include(request, response);
                }
            }
            else{
                request.setAttribute("error", "an error Occured!!!! or lawyer id equals PPID");
                request.getRequestDispatcher("addLawyerJudge.jsp").include(request, response);
            }
        }
            else{
                request.setAttribute("error", "InValid Hearing Date Procvided");
                request.getRequestDispatcher("addLawyerJudge.jsp").include(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(AddJudgeLawyerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
