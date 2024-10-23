<%-- 
    Document   : index
    Created on : 24-Sept-2024, 6:14:28 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('images/supreme.png'); /* Path to your background image */
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5); /* Add a shadow for depth */
            width: 400px; /* Fixed width for the form */
            position: absolute; /* Position it absolutely */
            top: 50%; /* Center vertically */
            left: 50%; /* Center horizontally */
            transform: translate(-50%, -50%); /* Offset by half its width and height */
        }
        h2 {
            text-align: center; /* Center the heading */
            margin-bottom: 20px;
        }
        .error-message {
            color: red; /* Color for the error message */
            text-align: center; /* Center the error message */
            margin-bottom: 20px; /* Spacing below the error message */
        }
        .form-control {
            border: 2px solid #000000; /* Blue border */
            border-radius: 5px; /* Rounded corners */
            transition: border-color 0.3s ease; /* Smooth transition for border color */
        }
        .form-control:focus {
            border-color: #0056b3; /* Darker blue on focus */
            box-shadow: 0 0 5px rgba(0, 86, 179, 0.5); /* Add shadow on focus */
        }
        .btn-primary {
            background-color: #007bff; /* Primary button color */
            border: none; /* Remove default border */
        }
        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
     <% 
 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//             //HTTP 1.1 version
//             //HTTP 1.0version
             response.setHeader("Pragma","no-cache");
             response.setHeader("Expires", "0");
        %>
    <div class="login-container">
        <%-- Check if an error message is available in request scope --%>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <h3 class="error-message"><%= errorMessage %></h3>
        <%
            }
        %>
        <h2>Login</h2>
        <form action="login" method="post">
            <div class="form-group">
                <label for="user">Select User Type:</label>
                <select name="user" class="form-control" required>
                    <option value="select" selected>--select user type---</option>
                    <option value="Lawyer">Lawyer</option>
                    <option value="Judge">Judge</option>
                    <option value="Registrar">Registrar</option>
                    <option value="Station">Police Officer</option>
                </select>
            </div>
            <div class="form-group">
                <label for="username">Enter UserName:</label>
                <input type="text" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Enter Password:</label>
                <input type="password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success btn-block">Login</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
