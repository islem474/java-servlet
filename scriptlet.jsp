
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scriptlet JSP</title>
</head>
<body>

    <h1>Informations</h1>

    <%
        java.util.Date date = new java.util.Date();

        String host = request.getRemoteHost();
    %>

    <p>Date et heure actuelles : <%= date %></p>

    <p>Remote Host : <%= host %></p>

</body>
</html>
