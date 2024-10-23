<%-- 
    Document   : ViewAllCases
    Created on : 18-Oct-2024, 9:55:22 am
    Author     : rguktrkvalley
--%>

<%@page import="java.util.List"%>
<%@page import="Beans.Cases"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Cases</title>
        <link href="CSS/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h2>All Cases Data</h2>
<!--      <a href="logout">Logout</a>-->
<a href="viewsortcases?sortBy=hearingDate" class="mylinks"><p>Sort by Hearing Date</p></a>
        <%
           List<Cases> listcase = null;
           String access ="Registrar";
           if(request.getAttribute("list")!=null){
                listcase = (List<Cases>)request.getAttribute("list");
            }
            if(request.getAttribute("access")!=null){
                access = (String)request.getAttribute("access");
            }
         //   System.out.println(access+" from Jsp Cases");
            String success = null;
            String error = null;
            if(request.getAttribute("success")!=null){
                success = (String)request.getAttribute("success");
        %><h2 style="color:green;"><%=success%></h2>
        <%}%>
        <%
            if(request.getAttribute("error")!=null){
                error = (String)request.getAttribute("error");
        %><h2 style="color:red;"><%=error%></h2>
        <%}%>
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
             <%
                 if(!access.equals("Judge")){
             %>
                <th>Update</th>
                <th>Delete</th>   
              <%}%>
            </tr>
            </thead>
            <tbody>
            <%
                int c= listcase.size();
                for(int i=0;i<c;i++){
                    boolean status = listcase.get(i).isIsJudgementPassed();
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
                    if(listcase.get(i).isIsJudgementPassed()){
                    out.println("<td> Case Closed</td>");
                     }
                     else{
                    out.println("<td>"+listcase.get(i).getHearingDate()+"</td>");
                         }
                    out.println("<td><a href='viewcase?caseid="+listcase.get(i).getCaseId()+"'>View</a></td>");
                    if(!access.equals("Judge")){
                        if(!status){
                        out.println("<td><a href='UpdateCase.jsp?caseid="+listcase.get(i).getCaseId()+"'>Update</a></td>");
                        }
                        else{
                          out.println("<td><a href='#' onclick='alert(\"Cannot Update a Closed Case.\")' style='color:gray;  cursor:default;'>Update</a></td>");
                        }
                        out.println("<td><a href='deleteCase?caseid="+listcase.get(i).getCaseId()+"'>Delete</a></td>");
                }
                    out.println("</tr>");
                }
            %>
            </tbody>
            
            <!-- 
            
                if(jStatus){
                       
                         out.println("<td><a href='#' onclick='alert(\"Judgment already passed for this case.\")' style='color:gray;  cursor:default;'>Judgment</a></td>");
                    }
                    else{
                    out.println("<td><a href='PassJudgement.jsp?caseid="+listcase.get(i).getCaseId()+"'>Judgement</a></td>");
                    }
                
            -->
        </table>
    </body>
</html>
