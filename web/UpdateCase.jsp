<%-- 
    Document   : UpdateCase
    Created on : 18-Oct-2024, 2:09:27 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Case Details</title>
    </head>
    <body>
        <!--<a href="viewallcases">Back to Caseslist</a>-->
        <h2>Update Case Details</h2>
        <%
            String caseid = request.getParameter("caseid");
            String success=null;
            String error=null;
            if(request.getAttribute("success")!=null){
                 success = (String)request.getAttribute("success");
        %>
        <h2 style="color:green;"><%= success%></h2>
        <%}%>
        <%
             if(request.getAttribute("error")!=null){
                 error = (String)request.getAttribute("error");
        %>
        <h2 style="color:red;"><%= error%></h2>
        <%}%>
        <form action="updateCase" method="post">
            <input type="hidden" name="caseId" value="<%=caseid%>"/><br><br>     
   <!--         <label>Case Status:</label>
            <select name="caseStatus" id="status" onchange="toggleDetails()">
                <option value="Pending">Pending</option>
                <option value="Closed/Completed">Closed/Completed</option>
            </select>
            <br><br>-->

            <label>Next Hearing Date:</label>
            <input type="date" name="hearingDate" required/><br><br>

            <label>Case Summary:</label>
            <textarea name="caseSummary" required></textarea><br><br>

<!--            <div id="addendDate" style="display:none;">
                <label>End Date:</label>
                <input type="date" name="endDate"/><br><br>
            </div>-->
            
            <input type="submit" value="Update Case"/>
        </form>

        <script>
            // Function to toggle End Date field visibility
//            function toggleDetails() {
//                var selectedValue = document.getElementById("status").value;
//                var detailsField = document.getElementById("addendDate");
//
//                // Show End Date field only if status is "Closed/Completed"
//                if (selectedValue === "Closed/Completed") {
//                    detailsField.style.display = "block"; // Show field
//                } else {
//                    detailsField.style.display = "none";  // Hide field
//                }
//            }
//
//            // Call toggleDetails on page load to check current status
//            window.onload = function() {
//                toggleDetails();
//            };
        </script>
    </body>
</html>
