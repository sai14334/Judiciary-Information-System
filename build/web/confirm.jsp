<%-- 
    Document   : confirm
    Created on : 07-Oct-2024, 2:47:06 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
        <style>
            h2{
                text-align: center;
            }
        </style>
    </head>
    <body>
       
       <%
           String AckSent = null;
           if(request.getAttribute("AckSent")!=null){
                    AckSent = (String)request.getAttribute("AckSent");
       %>
       <h2 style="color:green;"><%=AckSent%></h2>
       <%}%>
       
       <%
           String  UserAdded= null;
           if(request.getAttribute("UserAdded")!=null){
                    UserAdded = (String)request.getAttribute("UserAdded");
       %>
       <h2 style="color:green;"><%=UserAdded%></h2>
       <%}%>
       
       <%
           String Registered = null;
           if(request.getAttribute("Registered")!=null){
                    Registered = (String)request.getAttribute("Registered");
       %>
       <h2 style="color:green;"><%=Registered%></h2>
       <%}%>

       <%
           String  userRemoved = null;
           if(request.getAttribute("userRemoved")!=null){
                    userRemoved = (String)request.getAttribute("userRemoved");
       %>
       <h2 style="color:green;"><%=userRemoved%></h2>
       <%}%>
    </body>
</html>
