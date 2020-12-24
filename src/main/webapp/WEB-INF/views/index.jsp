<!DOCTYPE html>
<html>
    <head>
        <title>ToDo</title>
    </head>

    <body>
        <%@include file="menu.jsp"%>
        <p>Bonjour</p>
        <c:set var="pseudo" value="Ju" scope="page"/>
        <p><c:out value="${ pseudo }" /></p>
    </body>
</html>