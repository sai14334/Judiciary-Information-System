<%-- 
    Document   : DisplayCases
    Created on : 17-Oct-2024, 3:49:53 pm
    Author     : rguktrkvalley
--%>

<%@page import="java.util.List"%>
<%@page import="Beans.Cases"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cases</title>
         <link href="CSS/styles.css" rel="stylesheet" />
    </head>
    <body>
<!--        <a href="logout">Logout</a>-->
       <%
           // Registrar reg=new Registrar();
            
            List<Cases> caseslist =null; // reg.getUnregisteredDetails();
           System.out.println("IN Jsp"+request.getAttribute("list"));
            if(request.getAttribute("list")!=null){
               caseslist  = (List<Cases>)request.getAttribute("list");}
          //  int n= caseslist.size();
       %>
<!--       <a href="Registrar.jsp">Back</a> -->
       <%--   <c:if test="${not empty caseslist}">--%>
       <h2 style="color:orange;">UnRegistered Cases</h2>
        <table cellspacing="0" class="styled-table">
            <thead>
            <tr>
                <th>Case ID</th>
                <th>Defendant Name</th>
                <th>Crime Date</th>
                <th>Case Status</th>
                <th>Update</th>
                <!--<th>Delete</th>-->
            </tr>
            </thead>
            <tbody>
            <%--  <c:forEach items="${caseslist}" var="caseItem">--%>
               
                    <% 
                        
                      int n=caseslist.size();
                       for(int i=0;i<n;i++){
                            Cases temp=caseslist.get(i);
                            out.println("<tr>");
                            out.println("<td>"+temp.getCaseId()+"</td>");
                            out.println("<td>"+temp.getDefendantName()+"</td>");
                            out.println("<td>"+temp.getCrimeDate()+"</td>");
                            out.println("<td>"+temp.getCaseStatus()+"</td>");
                            out.println("<td><a href='addLawyerJudge.jsp?caseId="+temp.getCaseId()+"'>Update</a>"+"</td>");
                            //out.println("<td><a href='removecase?caseId="+temp.getCaseId()+"'>Delete</a>"+"</td>");
                            out.println("</tr>");
                        }
                    %>
                    
                    <%-- </c:forEach>--%>
            </tbody>
        </table>
       <%-- </c:if>--%>
    </body>
</html>
