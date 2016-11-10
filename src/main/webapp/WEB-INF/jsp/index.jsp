<html>
<head>
    <title>Free Ticket</title>

    <script type="text/javascript" src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/handlebars.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>

    <script type="text/javascript" src="/resources/js/mainPage.js"></script>
    <script type="text/javascript" src="/resources/js/login.js"></script>

    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div id="content">
    <div class="container">
        <div class="row">
            <div class="col-md-4">

            </div>
            <div class="col-md-4">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputUsername" class="sr-only">Username</label>
                <input type="text" id="inputUsername" class="form-control" placeholder="Username" required="" autofocus="">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
                <button class="btn btn-sm btn-primary btn-block" id="logIn">Log in</button>
                <button class="btn btn-sm btn-primary btn-block" id="register">Register</button>
            </div>
            <div class="col-md-4">

            </div>
        </div>


       <%-- <form class="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputUsername" class="sr-only">Username</label>
            <input type="text" id="inputUsername" class="form-control" placeholder="Username" required="" autofocus="">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
            <button class="btn btn-sm btn-primary btn-block" id="logIn">Log in</button>
            <button class="btn btn-sm btn-primary btn-block" id="register">Register</button>
        </form>--%>
    </div>
</div>

<script>
    $(function() {
        var login = new Login();
        login.init();
    });
</script>

</body>
</html>