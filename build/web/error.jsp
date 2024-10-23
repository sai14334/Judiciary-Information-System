<%-- 
    Document   : error
    Created on : 11-Oct-2024, 8:52:46 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <style>
            h2{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%
            String error = null;
            if(request.getAttribute("error")!=null){
            error = (String)request.getAttribute("error");
            
        %> <h2 style="color:red;"><%=error%></h2>
        <%}%>
        <%
           String AckFailed = null;
           if(request.getAttribute("AckFailed")!=null){
                    AckFailed = (String)request.getAttribute("AckFailed");
       %>
       <h2 style="color:red;"><%=AckFailed%></h2>
       <%}%>
       <%
           String Ackerror = null;
           if(request.getAttribute("Ackerror")!=null){
                    Ackerror = (String)request.getAttribute("Ackerror");
       %>
       <h2 style="color:red;"><%=Ackerror%></h2>
       <%}%>
       <%
           String  UserNotAdded= null;
           if(request.getAttribute("UserNotAdded")!=null){
                    UserNotAdded = (String)request.getAttribute("UserNotAdded");
       %>
       <h2 style="color:red;"><%=UserNotAdded%></h2>
       <%}%>
       <%
       //  Unregister
            String Illegal = null;
            if(request.getAttribute("Illegal")!=null){
        Illegal = (String)request.getAttribute("Illegal");
        %><h2 style="color:red;"><%=Illegal%></h2>
        <%}%>
       <%
           String retrivefailed = null;
           if(request.getAttribute("retrivefailed")!=null){
                    retrivefailed = (String)request.getAttribute("retrivefailed");
       %>
       <h2 style="color:red;"><%=retrivefailed%></h2>
       <%}%>
       
        <%
           String unabletoview = null;
           if(request.getAttribute("unabletoview")!=null){
                    unabletoview = (String)request.getAttribute("unabletoview");
       %>
       <h2 style="color:red;"><%=unabletoview%></h2>
       <%}%>
    
       <%
           String allnotview = null;
           if(request.getAttribute("allnotview")!=null){
                    allnotview = (String)request.getAttribute("allnotview");
       %>
       <h2 style="color:red;"><%=allnotview%></h2>
       <%}%>
       
    </body>
</html>
