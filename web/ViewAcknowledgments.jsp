<%-- 
    Document   : ViewAcknowledgnemts
    Created on : 20-Oct-2024, 11:28:20 am
    Author     : rguktrkvalley
--%>

<%@page import="com.uprooters.beans.Acknowledgment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Acknowledgment Page</title>
        <link href="CSS/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h2>Acknowledgments List</h2>
        <%
            List<Acknowledgment> list = null;
            if(request.getAttribute("AckList") != null)
                list = (List<Acknowledgment>)request.getAttribute("AckList");
        %>
        <table cellspacing="0" class="styled-table">
            <thead>
            <tr>
                <th>Case ID</th>
                <th>Acknowledgment Desc</th>
                <th>Station ID</th>
                <th>View</th>
            </tr>
            </thead>
            <tbody>
            <%
                int count = list.size();
                for(int i=0;i<count;i++){
                    out.println("<tr>");
                    out.println("<td>"+list.get(i).getCaseId()+"</td>");
                    out.println("<td>"+list.get(i).getAkcDesc()+"</td>");
                    out.println("<td>"+list.get(i).getStationId()+"</td>");
                    out.println("<td><a href='viewcase?caseid="+list.get(i).getCaseId()+"'>View</a></td>");
                    out.println("</tr>");
                
                }
            %>
            </tbody>
        </table>
    </body>
</html>
