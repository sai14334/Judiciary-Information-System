<%@page import="com.uprooters.beans.Judge"%>
<%@page import="com.uprooters.beans.Lawyer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.uprooters.daoclasses.GetLawyersJudgeDao"%>
<%@page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Case Registration</title>
               <link href="CSS/forms.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <div class="form-container">
            <h1 class="form-header">Case Registration</h1>

            <% if (request.getAttribute("Unregister") != null) { %>
                <h2 class="error-message"><%= (String) request.getAttribute("Unregister") %></h2>
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
