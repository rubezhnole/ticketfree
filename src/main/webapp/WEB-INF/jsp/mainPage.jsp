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
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/mainPage">Ticket FREE</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="/event/create" target="_blank">Create Event</a></li>
                <li><a href="/ticket/load">My tickets</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>Find your event</h1>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <div id="imaginary_container">
                    <div class="input-group stylish-input-group">
                        <input id="searchText" type="text" class="form-control"  placeholder="Search" >
                        <span class="input-group-addon">
                        <button id="searchButton">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<div class="container">
        <div class="row">--%>
            <div <%--class="col-md-12" --%>id="searchResult">

            </div>
     <%--   </div>
    </div>--%>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
    </div>
</footer>

<script>
    $(function() {
        var mainPage = new MainPage();
        mainPage.init();
    })
</script>

<script id="searchResultTemplate" type="text/x-handlebars-template">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <table class="table">
                    <tbody>
                    {{#each this}}
                        <tr>
                            <td><a href="/event/load?eventId={{entityId}}" target="_blank">{{title}}</a></td>
                        </tr>
                    {{/each}}
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</script>
</body>
</html>