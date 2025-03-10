<%-- 
    Document   : ViewAssignedCases
    Created on : 19-Oct-2024, 10:58:15 am
    Author     : rguktrkvalley
--%>

<%@page import="com.uprooters.beans.Cases"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assigned Case Details</title>
        <link href="CSS/styles.css" rel="stylesheet" />

    </head>
    <body>
            <%
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
    %>
        <%
            List<Cases> listcase = null;
            if(request.getAttribute("list")!= null)
                listcase = (List<Cases>)request.getAttribute("list");
            String success = null;           
            if(request.getAttribute("Success")!=null){
                success = (String)request.getAttribute("Success");
                %><h2 style="color:green;"><%=success%></h2>
                <%}%>
                <% String error = null;
                    if(request.getAttribute("judgementerror")!=null){
                        error = (String)request.getAttribute("judgementerror"); %>
                        <h2 style="color:red;"><%=error%></h2>
                   <% }%>
                   <h2>Assigned Cases Details</h2>
                   <a href="viewsortjudge?sortBy=hearingDate" class="mylinks"><p>Sort by Hearing Date</p></a>

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
                <th> Pass judgment </th>
            </tr>
             </thead>
             <tbody>
            <%
                int c= listcase.size();
                for(int i=0;i<c;i++){
                   // int caseId = listcase.get(i).getCaseId(); // Get the case ID for each row
                    //Boolean isJudgmentPassed = (Boolean) request.getAttribute("completed" + caseId); // Fetch the judgment status from request attribute
                    boolean jStatus = listcase.get(i).isIsJudgementPassed();
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
                    System.out.println("from Jsp Page "+jStatus);
                    if(jStatus){
                       
                         out.println("<td><a href='#' onclick='alert(\"Judgment already passed for this case.\")' style='color:gray;  cursor:default;'>Judgment</a></td>");
                    }
                    else{
                    out.println("<td><a href='PassJudgement.jsp?caseid="+listcase.get(i).getCaseId()+"'>Judgement</a></td>");
                    }   
                    out.println("</tr>");
                }
            %>
             </tbody>
        </table>
        
    </body>
</html>
