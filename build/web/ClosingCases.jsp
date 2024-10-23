<%-- 
    Document   : ClosingCases
    Created on : 19-Oct-2024, 9:01:19 pm
    Author     : rguktrkvalley
--%>

<%@page import="java.util.List"%>
<%@page import="Beans.Cases"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close Case Details</title>
        <link href="CSS/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h2>Close Case Data</h2>
        <%
            List<Cases> listcase = null;
            if(request.getAttribute("list") != null)
                listcase = (List<Cases>)request.getAttribute("list");
        %>
        <%
            String error = null;
            String closed = null;
            String notclosed = null;
            if(request.getAttribute("error")!=null){
                error = (String)request.getAttribute("error");
            
        %>
        <h2 style="color:red;"><%=error%></h2>
        <%}%>
        <%
            if(request.getAttribute("CaseClosed") != null){
                    closed = (String)request.getAttribute("CaseClosed");
            
        %>
        <h2 style="color:green;"><%=closed%></h2><%}%>
        <%
            if(request.getAttribute("NotClosed") != null){
                    notclosed = (String)request.getAttribute("NotClosed");
            
        %>
        <h2 style="color:red;"><%=notclosed%></h2><%}%>
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
                <th> Close Case</th>
            </tr>
            </thead>
            <tbody>
            <%
                int c= listcase.size();
                for(int i=0;i<c;i++){
                    String status = listcase.get(i).getCaseStatus();
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
                    if(!listcase.get(i).isIsJudgementPassed()){
                     out.println("<td>"+listcase.get(i).getHearingDate()+"</td>");
                }
                else{
                    out.println("<td> Case Closed </td>");
                }
                
                    if(status.equals("Closed")){
                        out.println("<td><a href='#' onclick='alert(\"Case Closed Previously.\")' style='color:gray;  cursor:default;'>Closed</a></td>");
                    }
                    else{
                    out.println("<td><a href='Close?caseid="+listcase.get(i).getCaseId()+"'>Close</a></td>"); 
                }
                    out.println("</tr>");
                }
            %>
            </tbody>
            <!--if(jStatus){
                       
                         out.println("<td><a href='#' onclick='alert(\"Judgment already passed for this case.\")' style='color:gray;  cursor:default;'>Judgment</a></td>");
                    }
                    else{
                    out.println("<td><a href='PassJudgement.jsp?caseid="+listcase.get(i).getCaseId()+"'>Judgement</a></td>");
                    }  -->
        </table>
    </body>
</html>
