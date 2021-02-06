<%@include file="head.jsp"%>
<body>
    <%@include file="menu.jsp"%>
    <section class="container">
        <section class="row justify-content-center">
            <section class="col-12 col-sm-6 col-md-4">
                <form method="post" >
                    <div class="form-group">
                        <label for="inputEmail">Email address</label>
                        <input type="email" class="form-control" name="inputEmail" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword1">Password</label>
                        <input type="password" class="form-control" name="inputPassword1" id="inputPassword1" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword2">Reapeat password</label>
                        <input type="password" class="form-control" name="inputPassword2" id="inputPassword2" placeholder="Repeat password">
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
            </section>
        </section>
    </section>
</body>
</html>
