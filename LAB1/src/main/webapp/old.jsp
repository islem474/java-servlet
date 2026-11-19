
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personne née avant 1990</title>
</head>
<body>

    <h1>Informations de la personne</h1>

    <h2>Personne née avant 1990</h2>

    <jsp:useBean id="person"
                 type="lab.mvc.model.Person"
                 scope="request" />

    <p>First Name :
        <jsp:getProperty name="person" property="firstName" />
    </p>

    <p>Last Name :
        <jsp:getProperty name="person" property="lastName" />
    </p>

    <p>Birth Day :
        <jsp:getProperty name="person" property="birthDay" />
    </p>

    <p>Sex :
        <jsp:getProperty name="person" property="sex" />
    </p>

</body>
</html>
