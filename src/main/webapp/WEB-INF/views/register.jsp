<%@include file="head.jsp"%>
<body>
    <%@include file="menu.jsp"%>
    <section class="container">
        <section class="row justify-content-center">
            <section class="col-12 col-sm-6 col-md-4">
                <form class="form-container">
                    <div class="form-group">
                        <label for="InputEmail1">Email address</label>
                        <input type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="InputPassword1">Password</label>
                        <input type="password" class="form-control" id="InputPassword1" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="InputPassword2">Reapeat password</label>
                        <input type="password" class="form-control" id="InputPassword2" placeholder="Repeat password">
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
            </section>
        </section>
    </section>
</body>
</html>
