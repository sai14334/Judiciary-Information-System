<%-- 
    Document   : PastCase
    Created on : 20-Oct-2024, 11:30:47 pm
    Author     : rguktrkvalley
--%>

<%@page import="DaoClasses.LawyerAssignedCasesDao"%>
<%@page import="java.util.List"%>
<%@page import="DaoClasses.PastCaseListDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Past Case</title>
    </head>
    <body>
        <h2>Past Case ID List</h2>
        <%
            PastCaseListDao past = new PastCaseListDao();
            List<Integer> list = null;
            String uname = (String)session.getAttribute("username");
            LawyerAssignedCasesDao lad = new LawyerAssignedCasesDao();
            int lid = lad.getLawyerId(uname);
                list = past.getPastCases(lid);
                System.out.println(list);
            
        %>
        <%if(!list.isEmpty()){%>
        <form id="myform" method="get">
            <label>Select Past Case ID:</label>
            <select id="mySelect" name="caseid" onchange="updateAction()" required>
                
                <%
                    int size = list.size();
                    for(int i=0;i<size;i++){
                        out.println("<option value='"+list.get(i)+"'>"+list.get(i)+"</option>");
                    
                    }
                %>
            </select>
            <input type="submit" value="Submit">
        </form>
          <%} else{
          %>
          <h2 style="color:red;">No Past Cases Data Available</h2>
          <%}%>
          <script type="text/javascript">
              
              function updateAction(){
                  var selectedValue = document.getElementById("mySelect").value;
                  document.getElementById("myform").action="viewcase?caseid="+selectedValue;
                  
              }
          </script>
    </body>
</html>
