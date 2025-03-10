<%-- 
    Document   : removeUser
    Created on : 11-Oct-2024, 7:38:14 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove USer</title>
              
        <link href="CSS/forms.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <div class="form-container">
        <%
           String  failed = null;
           if(request.getAttribute("failed")!=null){
                   failed  = (String)request.getAttribute("failed");
       %>
       <h2 style="color:red;"><%=failed%></h2>
       <%}%>
       <h3 class="form-header">Enter Details of User To remove</h3>
        <form action="removeuser" method="post">
            Select User Type:<select name="type">
                <option value="null">---select User ---</option>
                <option value="L">Lawyer</option>
                <option value="J">Judge</option>
                <option value="R">Registrar</option>
                <option value="S">Station</option>
            </select> <br/>  
            Enter UserName: <input type="text" name="username" required><br/>
            <input type="submit" value="Submit">
        </form>
        </div>
    </body>
</html>
