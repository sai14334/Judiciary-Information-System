<%-- 
    Document   : EditPassword
    Created on : 18-Oct-2024, 8:50:12 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Password</title>
    </head>
    <body>
        <%  session = request.getSession();
            String username =(String)session.getAttribute("username");
            String success=null;
            String error=null;
            String oldpasserror=null;
            String newpasserror=null;
        %>
        <%
            if(request.getAttribute("success")!=null){
                success = (String)request.getAttribute("success");
        %><h2 style="color:green;"><%=success%></h2>
        <%}%>
        <%
            if(request.getAttribute("error")!=null){
                error = (String)request.getAttribute("error");
        %><h2 style="color:red;"><%=error%></h2>
        <%}%>
        <%
            if(request.getAttribute("oldpasserror")!=null){
                oldpasserror = (String)request.getAttribute("oldpasserror");
        %><h2 style="color:red;"><%=oldpasserror%></h2>
        <%}%>
        <%
            if(request.getAttribute("newpasserror")!=null){
                newpasserror = (String)request.getAttribute("newpasserror");
        %><h2 style="color:red;"><%=newpasserror%></h2>
        <%}%>
        <form action="editpassword" method="post">
            <input type="hidden" value="<%=username%>" name="username">
            <label for="user">Select User Type:</label>
                <select name="user"  required>
                    <option value="select" selected>--select user type---</option>
                    <option value="Lawyer">Lawyer</option>
                    <option value="Judge">Judge</option>
                    <option value="Registrar">Registrar</option>
                    <option value="Station">Police Officer</option>
                </select><br/>
            <label>Enter Old Password:</label>
            <input type="password" name="oldpass"><br/><!-- comment -->
            <label>Enter New Password:</label>
            <input type="password" name="newpass"><br/>
            <label>Re Enter New Password:</label>
            <input type="password" name="repass"><br/>
            <input type="submit" value="Update Password">
        </form>
    </body>
</html>
