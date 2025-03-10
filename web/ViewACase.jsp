<%-- 
    Document   : ViewACase
    Created on : 18-Oct-2024, 1:52:33 pm
    Author     : rguktrkvalley
--%>

<%@page import="com.uprooters.beans.Cases"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Case Details</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                padding: 20px;
            }

            h2 {
                text-align: center;
                color: #333;
                font-size: 24px;
                text-transform: uppercase;
                margin-bottom: 20px;
                border-bottom: 2px solid #ccc;
                padding-bottom: 10px;
            }

            .case-details {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ddd;
                background-color: #f9f9f9;
                border-radius: 8px;
                box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            }

            .case-details strong {
                display: inline-block;
                width: 160px;
                text-align: left;
                font-weight: bold;
                margin-bottom: 10px;
            }

            .no-print {
                position: absolute;
                top: 20px;
                right: 20px;
                background-color: #007BFF;
                color: white;
                border: none;
                padding: 10px 15px;
                font-size: 14px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .no-print:hover {
                background-color: #0056b3;
            }

            /* CSS styles for the print layout */
            @media print {
                body {
                    font-size: 14px;
                    color: #000;
                }
                .no-print {
                    display: none;
                }
            }
        </style>
    </head>
    <body>

        <!-- Dynamic Case Data Retrieval -->
        <%
            Cases cases = null;
            if(request.getAttribute("Case")!=null)
                cases = (Cases)request.getAttribute("Case");
        %>

        <h2>Case Details</h2>

        <div class="case-details">
            <strong>Case ID:</strong> <%= cases.getCaseId() %> <br>
            <strong>Defendant Name:</strong> <%= cases.getDefendantName() %> <br>
            <strong>Defendant Address:</strong> <%= cases.getDefendantAddress() %> <br>
            <strong>Crime Type:</strong> <%= cases.getCrimeType() %> <br>
            <strong>Crime Location:</strong> <%= cases.getCrimeLoc() %> <br>
            <strong>Crime Date:</strong> <%= cases.getCrimeDate() %> <br>
            <strong>Arrest Date:</strong> <%= cases.getArrestDate() %> <br>
            <strong>Lawyer Name:</strong> <%= cases.getLawyerName() %> <br>
            <strong>Officer Name:</strong> <%= cases.getOfficerName() %> <br>
            <strong>Start Date:</strong> <%= cases.getStartDate() %> <br>
            <strong>Case Status:</strong> <%= cases.getCaseStatus() %> <br>
            <strong>Judge Name:</strong> <%= cases.getJudgeName() %> <br>
            <strong>PP Name:</strong> <%= cases.getPpName() %> <br>
            <%if(cases.getEndDate()!= null){%>
            <strong>End Date:</strong> <%= cases.getEndDate() %> <br>
            <%}%>
            <%if(!cases.isIsJudgementPassed()){%>
            <strong>Next Hearing Date:</strong> <%= cases.getHearingDate() %> <br>
            <%} %>
            <strong>Case Summary:</strong> <%= cases.getCaseSummary() %> <br>
        </div>

        <!-- Print button -->
        <button class="no-print" onclick="printPage()">Print or Save as PDF</button>

        <script>
            // JavaScript function to trigger the print dialog
            function printPage() {
                window.print();
            }
        </script>
    </body>
</html>
