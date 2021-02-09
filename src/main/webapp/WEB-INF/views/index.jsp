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
                    <c:forEach var="taskList" items="${taskLists}">
                        <div class="row">
                            <form class="display-inline col-6" action="index" method="post"><!-- faire plutot un put quand on ajoute des données-->
                                <button name="taskList" value="${taskList.getId()}">${taskList.getLabel()}</button>
                            </form>
                            <form class="display-inline col-6" action="DeleteTaskList" method="post">
                                <button type="submit" class="TaskListDeleteForm" name="deleteTaskList" value="${taskList.getId()}">Delete</button>
                            </form>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <form class="display-inline col-12" action="AddTaskList" method="post">
                            <input type="text" name="label" placeholder="Enter the List label">
                            <button type="submit">Add</button>
                            <span class="error">${AddTaskListForm.errors['label']}</span>
                        </form>
                    </div>
                </section>
                <section class="col-sm-6">
                    <h4>Tasks</h4>
                        <c:forEach var="task" items="${tasks}">
                            <c:if test="${task.list_fk == current_tasklist_id}">
                                <div class="row">
                                    <form class="display-inline col-6" action="DeleteTask" method="post">
                                        <p class="display-inline">${task.getLabel()}</p>
                                        <button type="submit" class="TaskDeleteForm" name="deleteTask" value="${task.getId()}">Delete</button>
                                    </form>
                                </div>
                            </c:if>
                        </c:forEach>
                        <div class="row">
                            <form class="display-inline col-12" action="AddTask" method="post">
                                <input type="text" name="label" placeholder="Enter the Task label">
                                <input type="hidden" name="current_tasklist_id" value="${current_tasklist_id}">
                                <button type="submit">Add</button>
                                <span class="error">${AddTaskForm.errors['label']}</span>
                            </form>
                        </div>
                </section>
            </section>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>