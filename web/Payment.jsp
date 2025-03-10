<%-- 
    Document   : Payment
    Created on : 20-Oct-2024, 10:40:06 pm
    Author     : rguktrkvalley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
                <link href="CSS/forms.css" rel="stylesheet" type="text/css">

    </head>
    <body>
         <div class="form-container">
        <% 
           String NotUpdated = null;
           if(request.getAttribute("NotUpdated")!=null){
                  NotUpdated   = (String)request.getAttribute("NotUpdated");
       %>
       <h2 style="color:red;"><%=NotUpdated%></h2>
       <%}%>
       <%
           String failed = null;
           if(request.getAttribute("failed")!=null){
                failed     = (String)request.getAttribute("failed");
       %>
       <h2 style="color:red;"><%=failed%></h2>
       <%}%>
        <%
           String expired  = null;
           if(request.getAttribute("expired")!=null){
                 expired    = (String)request.getAttribute("expired");
       %>
       <h2 style="color:red;"><%=expired%></h2>
       <%}%>
       <%
           if(session.getAttribute("username") !=null){
       %>
        <h2 class="form-header">Make Payment</h2>
        <h3 style="color:orange;" class="form-header">Amount: &#8377;100 Per Case</h3>
        <form action="payment" method="post">
            
            <input type="hidden" name="amount" value="100.00"/> <!-- Set the required amount -->
            <input type="hidden" name="paymentStatus" id="paymentStatus"/>

            <input type="submit" value="Pay Now" onclick="processPayment()"/>
        </form>
        <%} else{
                   out.println("<h2 style='color:red;'>Session Expired</h2>");
                }%>
         </div>
        <script>
            function processPayment() {
                // Simulate payment status (success/failure). In real case, integrate payment gateway.
                var success = confirm("Simulate Payment: Click OK for success, Cancel for failure.");
                document.getElementById("paymentStatus").value = success ? "success" : "failure";
                document.forms[0].submit();
            }
        </script>
    </body>
</html>
