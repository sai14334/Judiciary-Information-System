<%-- 
    Document   : Judge
    Created on : 24-Sept-2024, 10:30:47 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Judge Page</title>
        <link href="CSS/registrar.css" rel="stylesheet">
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
            <h2 id="welcome"><%=uname %></h2>
            <form action="viewcase" method="GET" onsubmit="setNull()" target="myframe">
                <input type="text" id="getvalue" name="caseid" placeholder="Enter CIN">
                <button type="submit">Search</button> 
            </form>
        </div>
        <div class="contents">
        <div class="sidebar">  
            <h2>Tools</h2>
        <a href="viewassignedcases" id="firstlink" target="myframe">View Assigned Cases</a>
        <a href="viewallcases?access=Judge" target="myframe">View all Cases</a>
         <a href="EditPassword.jsp" target="myframe">Edit Password</a>
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
