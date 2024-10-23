<%-- 
    Document   : LawyerPayDetails
    Created on : 21-Oct-2024, 12:57:00 am
    Author     : rguktrkvalley
--%>

<%@page import="java.util.List"%>
<%@page import="DaoClasses.LawyerPaymentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Lawyer Payment</title>
    </head>
    <body>
        <h2>List of Available Lawyers</h2>
        <%      if(request.getAttribute("error") != null){
                    out.println("<h2 style='color:red;'>"+request.getAttribute("error")+"</h2>");
            }
                LawyerPaymentDao lpd = new LawyerPaymentDao();
                List<Integer> list = lpd.getLawyerIdList();
        %>
        <%
            if(!list.isEmpty()){
        %>
        <form action="checkpaymet" method="post">
            <!--Enter Lawyer UserName:<input type="text" name="uname" required><br/>-->
            <label> Select LawyerID</label>
            <select name="lawid"  required>
                <option value="0">---select Lawyer ID---</option>
                <%
                    int size=list.size();
                    for(int i=0;i<size;i++){
                        out.println("<option value="+list.get(i)+">"+list.get(i)+"</option>");
                    
                    }
                %>
            </select>
            <input type="submit" value="Submit">
        </form>
            <%} else { 
                    out.println("<h2 style='color:red;'>No Lawyer Exist</h2>");
               }%>
    </body>
</html>
