
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Password</title>
        <link href="CSS/forms.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="form-container">
            <h1 class="form-header">Edit Password</h1>

            <% 
                session = request.getSession();
                String username = (String) session.getAttribute("username");
                String success = null;
                String error = null;
                String oldpasserror = null;
                String newpasserror = null;
            %>

            <% if (request.getAttribute("success") != null) { 
                success = (String) request.getAttribute("success"); %>
                <h2 class="success-message"><%= success %></h2>
            <% } %>

            <% if (request.getAttribute("error") != null) { 
                error = (String) request.getAttribute("error"); %>
                <h2 class="error-message"><%= error %></h2>
            <% } %>

            <% if (request.getAttribute("oldpasserror") != null) { 
                oldpasserror = (String) request.getAttribute("oldpasserror"); %>
                <h2 class="error-message"><%= oldpasserror %></h2>
            <% } %>

            <% if (request.getAttribute("newpasserror") != null) { 
                newpasserror = (String) request.getAttribute("newpasserror"); %>
                <h2 class="error-message"><%= newpasserror %></h2>
            <% } %>

            <form action="editpassword" method="post">
                <input type="hidden" value="<%= username %>" name="username">

                <label for="user">Select User Type:</label>
                <select name="user" id="user" required>
                    <option value="select" selected>--Select user type--</option>
                    <option value="Lawyer">Lawyer</option>
                    <option value="Judge">Judge</option>
                    <option value="Registrar">Registrar</option>
                    <option value="Station">Police Officer</option>
                </select>

                <label for="oldpass">Enter Old Password:</label>
                <input type="password" name="oldpass" id="oldpass" required placeholder="Enter old password">

                <label for="newpass">Enter New Password:</label>
                <input type="password" name="newpass" id="newpass" required placeholder="Enter new password">

                <label for="repass">Re-enter New Password:</label>
                <input type="password" name="repass" id="repass" required placeholder="Re-enter new password">

                <input type="submit" value="Update Password">
            </form>
        </div>
    </body>
</html>
