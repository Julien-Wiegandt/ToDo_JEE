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
                    <div class="row">
                        <c:forEach var="taskList" items="${taskLists}">
                            <form class="TaskListForm col-12" action="index" method="post"><!-- faire plutot un put quand on ajoute des données-->
                                <button name="taskList" value="${taskList.getId()}">${taskList.getLabel()}</button>
                                <form class="col-12" action="DeleteTaskList" method="post">
                                    <button class="TaskListDeleteForm" name="taskList" value="${taskList.getId()}">Delete</button>
                                </form>
                            </form>
                        </c:forEach>
                        <form class="col-12" action="AddTaskList" method="post">
                            <input type="text" name="label" placeholder="Enter the List label">
                            <button type="submit">Add</button>
                            <span class="error">${AddTaskListForm.errors['label']}</span>
                        </form>
                    </div>

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