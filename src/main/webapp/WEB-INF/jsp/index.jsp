<html>
<head>
    <title>Free Ticket</title>

    <script type="text/javascript" src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/handlebars.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>

    <script type="text/javascript" src="/resources/js/mainPage.js"></script>
    <script type="text/javascript" src="/resources/js/login.js"></script>

    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <%--<link href="/resources/css/style.css" rel="stylesheet">--%>

    <style>
        body{
            background: #00589F;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00589F', endColorstr='#0073CF', GradientType=0);
            background: -webkit-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
            background: -moz-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
            background: -ms-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
            background: -o-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
            background: linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
            color: white;
        }

        div.well{
            height: 250px;
        }

        .Absolute-Center {
            margin: auto;
            position: absolute;
            top: 0; left: 0; bottom: 0; right: 0;
        }

        .Absolute-Center.is-Responsive {
            width: 50%;
            height: 50%;
            min-width: 200px;
            max-width: 400px;
            padding: 40px;
        }

        #logo-container{
            margin: auto;
            margin-bottom: 10px;
            margin-left: 50px;
            width:200px;
            height:30px;
            /*background-image:url('http://placehold.it/200x30/000000/ffffff/&text=BRAND+LOGO');*/
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="Absolute-Center is-Responsive">
            <div id="logo-container">Ticket FREE</div>
            <div class="col-sm-12 col-md-10 col-md-offset-1">
                <form action="" id="loginForm">
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control" type="text" name='username' placeholder="username"/>
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input class="form-control" type="password" name='password' placeholder="password"/>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> I agree to the <a href="#">Terms and Conditions</a>
                        </label>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-def btn-block">Login</button>
                    </div>
                    <div class="form-group text-center">
                        <a href="#">Forgot Password</a>&nbsp;|&nbsp;<a href="#">Support</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<%--<div id="content">
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


       &lt;%&ndash; <form class="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputUsername" class="sr-only">Username</label>
            <input type="text" id="inputUsername" class="form-control" placeholder="Username" required="" autofocus="">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
            <button class="btn btn-sm btn-primary btn-block" id="logIn">Log in</button>
            <button class="btn btn-sm btn-primary btn-block" id="register">Register</button>
        </form>&ndash;%&gt;
    </div>--%>
<%--</div>--%>

<script>
    $(function() {
        var login = new Login();
        login.init();
    });
</script>

</body>
</html>