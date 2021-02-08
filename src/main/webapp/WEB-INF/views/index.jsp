<%@include file="head.jsp"%>
<body>
<%@include file="menu.jsp"%>
<c:choose>
    <c:when test="${empty sessionScope.userSession}">
        <div class="container">
            <h1>ToDo-JEE</h1>
            <h4>Welcome to a JEE ToDo List app!</h4>
        </div>

    </c:when>
    <c:otherwise>
        <div class="container">
            <h1>ToDo</h1>
            <section class="row">
                <section class="col-sm-6">
                    <h4>Lists</h4>
                    <ul>
                        <c:forEach var="taskList" items="${taskLists}">
                            <li>${taskList.label}</li>
                        </c:forEach>
                    </ul>
                </section>
                <section class="col-sm-6">
                    <h4>Tasks</h4>
                    <ul>
                        <c:forEach var="task" items="${tasks}">
                            <li>${task.getLabel()}</li>
                        </c:forEach>
                    </ul>
                </section>
            </section>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>