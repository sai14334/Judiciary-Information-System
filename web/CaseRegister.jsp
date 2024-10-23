<%@page import="Beans.Judge"%>
<%@page import="Beans.Lawyer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DaoClasses.GetLawyersJudgeDao"%>
<%@page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Case Registration</title>
        <style>
            /* Form container styling */
            .form-container {
                max-width: 500px;
                margin: auto;
                background: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                font-family: 'Arial', sans-serif;
            }

            /* Form header styling */
            .form-header {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 20px;
                text-align: left;
                position: relative;
            }

            /* Orange underline under the header */
            .form-header::after {
                content: "";
                display: block;
                width: 50px;
                height: 4px;
                background-color: orange;
                position: absolute;
                left: 0;
                bottom: -10px;
            }

            /* Label and input styling */
            label {
                font-weight: bold;
                display: block;
                margin-bottom: 8px;
            }

            input[type="text"], input[type="date"], textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 16px;
                margin-bottom: 15px;
                transition: border-color 0.3s;
            }

            /* Focus effect for inputs */
            input[type="text"]:focus, input[type="date"]:focus, textarea:focus {
                outline: none;
                border-color: orange;
            }

            /* Submit button styling */
            input[type="submit"] {
                width: 100%;
                background-color: orange;
                color: white;
                padding: 15px;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            /* Submit button hover effect */
            input[type="submit"]:hover {
                background-color: darkorange;
            }

            /* Styling for error message */
            h2 {
                font-size: 18px;
                color: red;
            }

            /* Responsive design for mobile screens */
            @media (max-width: 600px) {
                .form-container {
                    width: 100%;
                    padding: 10px;
                }
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h1 class="form-header">Case Registration</h1>

            <% if (request.getAttribute("Unregister") != null) { %>
                <h2><%= (String) request.getAttribute("Unregister") %></h2>
            <% } %>

            <form action="register" method="post">
                <label for="defName">Defendant's Name:</label>
                <input type="text" name="defName" id="defName" placeholder="Enter defendant name" required>

                <label for="defAddress">Defendant's Address:</label>
                <textarea name="defAddress" id="defAddress" rows="2" cols="20" placeholder="Enter defendant address" required></textarea>

                <label for="crimeType">Crime Type:</label>
                <input type="text" name="crimeType" id="crimeType"placeholder="Enter type of crime" required>

                <label for="crimeDate">Crime Date:</label>
                <input type="date" name="crimeDate" id="crimeDate" placeholder="Select crime date" required>

                <label for="crimeLoc">Crime Location:</label>
                <textarea name="crimeLoc" id="crimeLoc" rows="2" cols="20" placeholder="Enter crime location" required></textarea>

                <label for="officerName">Arresting Officer:</label>
                <input type="text" name="officerName" id="officerName" placeholder="Enter arresting officer name" required>

                <label for="arrestDate">Arrest Date:</label>
                <input type="date" name="arrestDate" id="arrestDate" placeholder="Select arrest date" required>

                <label for="startDate">Start Date:</label>
                <input type="date" name="startDate" id="startDate" placeholder="Select case start date" required>

                <label for="summary">Case Summary:</label>
                <textarea name="summary" id="summary" rows="3" cols="20" placeholder="Enter case summary" required></textarea>

                <input type="submit" value="Submit Details">
            </form>
        </div>
    </body>
</html>
