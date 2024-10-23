<%-- 
    Document   : addLawyerJudge
    Created on : 17-Oct-2024, 8:26:00 pm
    Author     : rguktrkvalley
--%>

<%@page import="Beans.Judge"%>
<%@page import="Beans.Lawyer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.List"%>
<%@page import="DaoClasses.GetLawyersJudgeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD Lawyer Judge</title>
        
    </head>
    <body>
        <h2>Assign Lawyer and Judge</h2>
        <%  String caseId = request.getParameter("caseId");
            GetLawyersJudgeDao getdetails = new GetLawyersJudgeDao();
            ResultSet rsl = getdetails.getLawyerDetails();
            List<Lawyer> lawyerlist = new ArrayList<>();
            if(rsl!=null){
                while(rsl.next()){
                    Lawyer lawyer = new Lawyer();
                    lawyer.setLawyerId(rsl.getInt("LawyerID"));
                    lawyer.setFullName(rsl.getString("FullName"));
                    lawyerlist.add(lawyer);
                }
            }
            ResultSet rsg = getdetails.getJudgeDetails();
            List<Judge> judgelist = new ArrayList<>();
            if(rsg!=null){
                while(rsg.next()){
                    Judge judge = new Judge();
                    judge.setJudgeId(rsg.getInt("JudgeID"));
                    judge.setFullName(rsg.getString("FullName"));
                    judgelist.add(judge);
                }
            }
        %>
        <% 
            String confirm = (String) request.getAttribute("confirm");
    if (confirm != null) { 
%>
    <h2 style="color:green;"><%= confirm %></h2>
<% 
    } 
%>

<% 
    String error = (String) request.getAttribute("error");
    if (error != null) { 
%>
    <h2 style="color:red;"><%= error %></h2>
<% 
    } 
%>

        <form action="assignJL" method="post">
            <input type="hidden" name="caseId" value="<%=caseId%>"><br/>   
            <label for='lawyerId'>Defense Lawyer Name:</label>
            <%  int n = lawyerlist.size();
                out.println("<select name='lawyerId' id='lawyerDropdown' onchange='setLawyerName()' required>");
                out.println("<option value='0'>---Select Defence Lawyer Name----</option>");
                for(int i=0;i<n;i++){
                    out.println("<option value='"+lawyerlist.get(i).getLawyerId()+"'>"+
                    lawyerlist.get(i).getFullName()+"</option>");
                }
                
                out.println("</select>");            
           %>
           <br/>   <input type="hidden" name="lawyerName" id="nameField"><br/>
           <label for='PPId'>PP Name:</label>
           <%  int k = lawyerlist.size();
                out.println("<select name='PPId' id='PPList' onchange='setPPName()'>");
                out.println("<option value='0'>---Select Public Prosecutor Name----</option>");
                for(int i=0;i<k;i++){
                    out.println("<option value='"+lawyerlist.get(i).getLawyerId()+"'>"+
                    lawyerlist.get(i).getFullName()+"</option>");
                }
                
                out.println("</select>");            
           %>
           <br/><input type="hidden" name="PPName" id="PPnameField"><br/>
           <label>Select Judge Name:</label>
           <select name="judgeId" id="judgeList" onchange="setJudgeName()">
               <option value="0">---Select Judge----</option>
           <%
               int len = judgelist.size();
               for(int i=0;i<len;i++){
                    out.println("<option value='"+judgelist.get(i).getJudgeId()+"'>"+
                    judgelist.get(i).getFullName()+"</option>");
               }
               
           %>
           </select>
           <br/><input type="hidden" name="JudgeName" id="Judgename"><br/>
           <label>Enter Next Hearing Date:</label>
           <input type ="date" name="hearingdate"><br/>
           <input type="submit" value="Submit">
        </form>
        <script>
            function setLawyerName() {
                var select = document.getElementById("lawyerDropdown");
                var lawyerName = select.options[select.selectedIndex].text;
                document.getElementById("nameField").value = lawyerName;
            }
            function setPPName() {
                var selectPP = document.getElementById("PPList");
                var PPName = selectPP.options[selectPP.selectedIndex].text;
                document.getElementById("PPnameField").value = PPName;
            }
            function setJudgeName(){
                var selectJudge = document.getElementById("judgeList");
                var JudgeName = selectJudge.options[selectJudge.selectedIndex].text;
                document.getElementById("Judgename").value = JudgeName;
            }
        </script>
    </body>
</html>
