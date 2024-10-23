<%-- 
    Document   : addUser
    Created on : 11-Oct-2024, 10:49:22 am
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD User</title>
        
    </head>
    <body>
        <%
            String Failed =null;
            if(request.getAttribute("Failed")!=null){
                Failed= (String)request.getAttribute("Failed");
            
        %><h2 style="color:red;"><%=Failed%></h2>
        <%}%>
        <h2>Add User Form</h2>

        <form action="adduser" method="post">
            Select User Type:<select name="type">
                <option value="null">---select User ---</option>
                <option value="L">Lawyer</option>
                <option value="J">Judge</option>
                <option value="R">Registrar</option>
                <option value="S">Station</option>
            </select>  <br/> 
            Enter UserName: <input type="text" name="username" required onclick="showAlert()"><br/> 
            Enter Password:<input type="password" name="password" required><br/> 
            Re-Enter Password:<input type="password" name="repass" required><br/> <!-- comment -->
            Enter Email:<input type="email" name="email"><br/> 
            Enter Full Name:<input type="text" name="name"><br/> <!-- comment -->
            Enter Contact:<input type="tel" name="phone"><br/> 
            <input type="submit" value="Submit">  
        </form>
        <script type="text/javascript">
            function showAlert(){
                alert("Username Instructions:\n\
        1. Username should not be Empty\n\
        2.Username Must Be Unique\n\
        3.Username must start with first letter of their Designation\n\
        Ex:Laywer->L, Judge->J, Registrar->R, Station->S");
                
            }
        </script>
    </body>
</html>
