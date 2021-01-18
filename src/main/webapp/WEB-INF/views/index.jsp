<!DOCTYPE html>
<html>
    <%@include file="head.jsp"%>
    <body>
        <%@include file="menu.jsp"%>
        <p>Bonjour</p>
        <c:set var="pseudo" value="Ju" scope="page"/>
        <p><c:out value="${ pseudo }" /></p>
    </body>
</html>