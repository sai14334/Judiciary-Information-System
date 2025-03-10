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
        <link href="CSS/forms.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="form-container">
            <h1 class="form-header">Add User Form</h1>

            <% if (request.getAttribute("Failed") != null) { %>
                <h2><%= (String) request.getAttribute("Failed") %></h2>
            <% } %>

            <form action="adduser" method="post">
                <label for="type">Select User Type:</label>
                <select name="type" id="type" required>
                    <option value="null">--- Select User ---</option>
                    <option value="L">Lawyer</option>
                    <option value="J">Judge</option>
                    <option value="R">Registrar</option>
                    <option value="S">Station</option>
                </select>

                <label for="username">Enter Username:</label>
                <input type="text" name="username" id="username" required onclick="showAlert()" placeholder="Enter username">

                <label for="password">Enter Password:</label>
                <input type="password" name="password" id="password" required placeholder="Enter password">

                <label for="repass">Re-Enter Password:</label>
                <input type="password" name="repass" id="repass" required placeholder="Re-enter password">

                <label for="email">Enter Email:</label>
                <input type="email" name="email" id="email" placeholder="Enter email address">

                <label for="name">Enter Full Name:</label>
                <input type="text" name="name" id="name" placeholder="Enter full name">

                <label for="phone">Enter Contact:</label>
                <input type="tel" name="phone" id="phone" placeholder="Enter contact number">

                <input type="submit" value="Submit">
            </form>
        </div>

        <script type="text/javascript">
            function showAlert() {
                alert("Username Instructions:\n\
1. Username should not be empty.\n\
2. Username must be unique.\n\
3. Username must start with the first letter of their designation.\n\
Ex: Lawyer -> L, Judge -> J, Registrar -> R, Station -> S");
            }
        </script>
    </body>
</html>
