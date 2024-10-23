<%-- 
    Document   : PassJudgement
    Created on : 19-Oct-2024, 11:23:04 am
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Judgement Page</title>
    </head>
    <body>
        <h2>Enter Judgement Details</h2>
        <%
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        %>
        <%
           String caseid = request.getParameter("caseid");
        %>
        <%
            String dateerror = null;
            if(request.getAttribute("dateerror")!=null){
                dateerror = (String)request.getAttribute("dateerror");
                %><h2 style="color:red;"><%=dateerror%></h2>
                <%}%>
        <form action="judgement" method="post">
            <input type="hidden" name="caseId"  value="<%=caseid%>"><!-- comment -->
            <br>    <label> Enter Judgement Description:</label>
            <!--<input type="text" name="judgedesc">--> 
            <textarea name="judgedesc" rows="5" cols="10" required></textarea><br/>
            <label>Enter Judgement Date:</label>
            <input type="date" name="judgedate">
            <input type="submit" value="Pass Judgement">
        </form>
    </body>
</html>
