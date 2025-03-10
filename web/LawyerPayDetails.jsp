<%-- 
    Document   : LawyerPayDetails
    Created on : 21-Oct-2024, 12:57:00 am
    Author     : rguktrkvalley
--%>

<%@page import="java.util.List"%>
<%@page import="com.uprooters.daoclasses.LawyerPaymentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Lawyer Payment</title>
                        <link href="CSS/forms.css" rel="stylesheet" type="text/css">

    </head>
    <body>
         <h2  style="font-size: 28px;font-weight: bold;margin-bottom: 20px;text-align: center;">Lawyer Payment Details</h2>
        <div class="form-container">
        <h2 class="form-header">List of Available Lawyers</h2>
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
        </div>
    </body>
</html>
