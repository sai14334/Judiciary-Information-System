<%-- 
    Document   : Registrar
    Created on : 24-Sept-2024, 10:30:16 pm
    Author     : rguktrkvalley
--%>

<%@page import="com.uprooters.beans.Registrar"%>
<%@page import="com.uprooters.daoclasses.UnRegisterRetriveDao"%>
<%@page import="java.util.List"%>
<%@page import="com.uprooters.beans.Cases"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Page</title>
        <link href="CSS/registrar.css" rel="stylesheet" />
    </head>
    <body>
      <% 
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
            response.setHeader("Pragma","no-cache");
            response.setHeader("Expires", "0");
            if(session.getAttribute("username")==null){
                response.sendRedirect("index.jsp");
            }
             String uname = (String)session.getAttribute("username");
        %>
        <div class="head">
            <h2 id="welcome"><%=uname%></h2>

            <form action="viewcase" method="get" onsubmit="setNull()" target="myframe">
                <input type="text" id="getvalue" name="caseid" placeholder="Enter CIN">
                <button type="submit">Search</button> 
            </form>
        </div>
        <div class="contents">
        <div class="sidebar">  
            <h2>Tools</h2>
        <a href="registercase" id="firstlink" target="myframe">Unregistered cases</a>
        <a href="addUser.jsp" target="myframe">ADD User</a>
        <a href="removeUser.jsp" target="myframe">Remove User</a>
        <a href="viewallcases?access=Registrar" target="myframe">View and Edit Cases</a>
        <a href="EditPassword.jsp" target="myframe">Edit Password</a>
        <a href="canclosecases" target="myframe">Close Case</a>
        <a href="sendacknowledgment" target="myframe"> Send Ack </a>
        <a href="LawyerPayDetails.jsp" target="myframe">Check Payment</a>
        <a href='logout' >Logout</a>
        </div>
        <div class="main">
        <iframe  name="myframe"> </iframe>
        </div>
        </div>
            <script type="text/javascript">
                function setNull(){
                    setTimeout(function (){
                        document.getElementById("getvalue").value="";
                    },40);
                    
                }
                window.onload = function (){
                    
                    document.getElementById("firstlink").click();
                } ;

            </script>
    </body>
</html>
