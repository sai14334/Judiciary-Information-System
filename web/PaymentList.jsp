<%-- 
    Document   : PaymentList
    Created on : 21-Oct-2024, 2:20:28 pm
    Author     : rguktrkvalley
--%>

<%@page import="com.uprooters.beans.PaymentDetails"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payments List</title>
        <link href="CSS/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h2> Payments List of Lawyer</h2>
        <%
            String NoList=null;
            if(request.getAttribute("NoList")!=null){
                NoList = (String)request.getAttribute("NoList");
            
        %><h2 style="color:red;"><%=NoList%></h2>
        <%}%>
        <%
            List<PaymentDetails> list = null;
            if(request.getAttribute("PaymentList")!=null){
                list = (List<PaymentDetails>)request.getAttribute("PaymentList");
            }
        %>
        <table cellspacing="0" class="styled-table">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Amount</th>
                <th>Payment Status</th>
                <th>Payment Date</th>
            </tr>
            </thead>
            <tbody>
            <%
                if(list != null){
                    int count = list.size();
                    for(int i=0;i<count;i++){
                        out.println("<tr>");
                        out.println("<td>"+list.get(i).getLawyerId()+"</td>");
                        out.println("<td>"+list.get(i).getAmount()+"</td>");
                        out.println("<td>"+list.get(i).getPaymentStatus()+"</td>");
                        out.println("<td>"+list.get(i).getPaymentDate()+"</td>");
                        out.println("</tr>");
                    }
                
            %>
            </tbody>
        </table>
        <%} else{
                out.println("<h2>No Data Available!!!!!</h2>");
        }%>
    </body>
</html>
