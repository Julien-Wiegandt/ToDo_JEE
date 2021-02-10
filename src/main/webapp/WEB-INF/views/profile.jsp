<c:choose>
    <c:when test="${empty sessionScope.userSession}">
        <c:redirect url="/"/>
    </c:when>
    <c:otherwise>
        <%@include file="head.jsp" %>
        <body>
        <%@include file="menu.jsp" %>
        <section class="container">
            <section class="row justify-content-center">
                <section class="col-12 col-sm-6 col-md-4">
                    <form method="post" action="profile">
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" name="email" id="email"
                                   aria-describedby="emailHelp" value="${sessionScope.userSession.getEmail()}">
                            <!--placeholder="Enter email"-->
                            <span class="errors">${form.errors['email']}</span>
                        </div>
                        <div class="form-group">
                            <label for="password1">Password</label>
                            <input type="password" class="form-control" name="password1" id="password1"
                                   placeholder="Password">
                            <span class="errors">${form.errors['password1']}</span>
                        </div>
                        <div class="form-group">
                            <label for="password2">Repeat password</label>
                            <input type="password" class="form-control" name="password2" id="password2"
                                   placeholder="Repeat password">
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </section>
            </section>
        </section>
        </body>
        </html>
    </c:otherwise>
</c:choose>