<%-- 
    Document   : ViewLawyerCases
    Created on : 20-Oct-2024, 9:50:04 pm
    Author     : rguktrkvalley
--%>

<%@page import="com.uprooters.beans.Cases"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lawyer Assigned Cases</title>
        <link href="CSS/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h2>Assigned Cases Details</h2>
        <a href="viewsortcases?sortBy=hearingDate&from=Lawyer" class="mylinks"><p>Sort by Hearing Date</p></a>
        <%
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
    %>
    <%
        List<Cases> listcase = null;
        if(request.getAttribute("list") != null){
            listcase = (List<Cases>)request.getAttribute("list");
        }
    %>
    <%
        String listerror = null;
        String expired = null;
        if(request.getAttribute("listerror") != null){
            listerror = (String)request.getAttribute("listerror");
            %><h2 style="color:red;"><%=listerror%></h2>
            <%}%>
            <%
                if(request.getAttribute("expired") != null){
                    expired = (String)request.getAttribute("expired");
            %><h2 style="color:red;"><%=expired%></h2>
            <%}%>
            <%
                if(session.getAttribute("username")==null){
                    //request.setAttribute("error", "session expired logout and log in again");
                    response.sendRedirect("error.jsp");
                }
            %>
            <table cellspacing="0" class="styled-table">
                <thead>
                <tr>
                    <th>Case ID</th>
                    <th>Defendant Name</th>
                    <th>Defendant Address</th>
                    <th>Crime Date</th>
                    <th>Arrest Date</th>
                    <th>Officer Name</th>
                    <th>Lawyer Name</th>
                    <th>PPName</th>
                    <th>Case Status</th>
                    <th>Next Hearing Date</th>
                    <th>View Case</th>
                </tr>
                </thead>
                <tbody>
                <%
                int c= listcase.size();
                for(int i=0;i<c;i++){
                    out.println("<tr>");
                    out.println("<td>"+listcase.get(i).getCaseId()+"</td>");
                    out.println("<td>"+listcase.get(i).getDefendantName()+"</td>");
                    out.println("<td>"+listcase.get(i).getDefendantAddress()+"</td>");
                    out.println("<td>"+listcase.get(i).getCrimeDate()+"</td>");
                    out.println("<td>"+listcase.get(i).getArrestDate()+"</td>");
                    out.println("<td>"+listcase.get(i).getOfficerName()+"</td>");
                    out.println("<td>"+listcase.get(i).getLawyerName()+"</td>");
                    out.println("<td>"+listcase.get(i).getPpName()+"</td>");
                    out.println("<td>"+listcase.get(i).getCaseStatus()+"</td>");
                    out.println("<td>"+listcase.get(i).getHearingDate()+"</td>");
                    out.println("<td><a href='viewcase?caseid="+listcase.get(i).getCaseId()+"'>View</a></td>");
                    out.println("</tr>");
                    }
                 %>
                </tbody>
            </table>
    </body>
</html>
