<%@include file="head.jsp"%>
<body>
    <%@include file="menu.jsp"%>
    <section class="container">
        <section class="row justify-content-center">
            <section class="col-12 col-sm-6 col-md-4">
                <c:choose>
                    <c:when test="${!empty sessionScope.userSession}">
                        <p> <c:out value="Connected as ${sessionScope.userSession.getEmail()}"/> </p>
                    </c:when>
                    <c:otherwise>
                        <form method="post" action="login">
                            <div class="form-group">
                                <label for="email">Email address</label>
                                <input type="email" class="form-control" name="email" id="email" value="<c:out value="${user.getEmail()}"/>" aria-describedby="emailHelp" placeholder="Enter email">
                                <span class="errors">${form.errors['email']}</span>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                                <span class="error">${form.errors['password']}</span>
                            </div>
                            <!--
                            <div class="form-check">
                                <input type="checkbox" name="remember" class="form-check-input" id="remember">
                                <label class="form-check-label" for="remember">Remember me</label>
                            </div>
                            -->
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </section>
        </section>
    </section>
</body>
</html>
