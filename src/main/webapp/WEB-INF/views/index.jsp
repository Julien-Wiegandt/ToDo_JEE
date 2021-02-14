<%@include file="head.jsp" %>
<body>
<%@include file="menu.jsp" %>
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
                <section class="col-12 col-sm-6">
                    <h4>Lists</h4>
                    <div class="d-flex flex-column">
                        <c:forEach var="taskList" items="${taskLists}">
                            <div class="p-2">
                                <div class="row">
                                    <div class="col-xs-9">
                                        <form action="index" method="post">
                                            <!-- faire plutot un put quand on ajoute des données-->
                                            <c:choose>
                                                <c:when test="${taskList.getId() == sessionScope.current_tasklist_id}">
                                                    <button name="taskList" class="full-width TaskList ActiveTaskList" value="${taskList.getId()}">${taskList.getLabel()}</button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button name="taskList" class="full-width TaskList" value="${taskList.getId()}">${taskList.getLabel()}</button>
                                                </c:otherwise>
                                            </c:choose>
                                        </form>
                                    </div>
                                    <div class="col-xs-3">
                                        <form action="DeleteTaskList" method="post">
                                            <button type="submit" class="TaskListDeleteForm" name="deleteTaskList" value="${taskList.getId()}">Delete</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="p-2">
                            <form action="AddTaskList" method="post">
                                <input type="text" name="label" placeholder="Enter the List label">
                                <button type="submit">Add</button>
                                <span class="error">${AddTaskListForm.errors['label']}</span>
                            </form>
                        </div>
                    </div>
                </section>
                <section class="col-12 col-sm-6">
                    <h4>Tasks</h4>
                    <div class="d-flex flex-column">
                        <c:forEach var="task" items="${tasks}">
                            <c:if test="${task.list_fk == sessionScope.current_tasklist_id}">
                                <div class="p-2">
                                    <div class="row">
                                        <div class="col-xs-9">
                                            <p>${task.getLabel()}</p>
                                        </div>
                                        <div class="col-xs-3">
                                            <form action="DeleteTask" method="post">
                                                <button type="submit" class="TaskDeleteForm" name="deleteTask"
                                                        value="${task.getId()}">Delete
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                        <div class="p-2">
                            <form action="AddTask" method="post">
                                <input type="text" name="label" placeholder="Enter the Task label">
                                <button type="submit">Add</button>
                                <span class="error">${AddTaskForm.errors['label']}</span>
                            </form>
                        </div>
                    </div>
                </section>
            </section>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>