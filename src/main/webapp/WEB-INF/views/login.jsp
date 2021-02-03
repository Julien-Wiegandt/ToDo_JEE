<%@include file="head.jsp"%>
<body>
    <%@include file="menu.jsp"%>
    <section class="container">
        <section class="row justify-content-center">
            <section class="col-12 col-sm-6 col-md-4">
                <c:choose>
                    <c:when test="${ !empty email }">
                        <p> <c:out value="${email} connected"/> </p>
                    </c:when>
                    <c:otherwise>
                        <form method="post" action="login">
                            <div class="form-group">
                                <label for="inputEmail">Email address</label>
                                <input type="email" class="form-control" name="inputEmail" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">Password</label>
                                <input type="password" class="form-control" name="inputPassword" id="inputPassword" placeholder="Password">
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="check">
                                <label class="form-check-label" for="check">Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </section>
        </section>
    </section>
</body>
</html>
