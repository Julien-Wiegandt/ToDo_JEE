<%--
  Created by IntelliJ IDEA.
  User: wiega
  Date: 24/12/2020
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>My ToDo</title>
    </head>

    <body>
        <%@include file="menu.jsp"%>
        <h1>My ToDo</h1>
        <c:forEach items="${ lists }" var="title" begin="0" end="1">
            <p> <c:out value="${ title }"/> </p>
        </c:forEach>
    </body>
</html>
