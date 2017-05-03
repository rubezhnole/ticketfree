<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/handlebars.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="/resources/js/ticket.js"></script>

    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

<input type="hidden" id="userId" value="${userId}"/>


<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
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
<div class="container" id="ticketContainer">

</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
    </div>
</footer>

<script>
    var ticket = new Ticket();

    $(function() {
        ticket.init();
        ticket.load();
    })
</script>

<script id="ticketTemplate" type="text/x-handlebars-template">
    {{#each this}}
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <ul class="list-group">
                        <li class="list-group-item"><div>{{event.title}} {{event.dateStart}}</div></li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-1">

                    </div>
                    <div class="col-md-11">
                        <ul class="list-group">
                            {{#each tickets}}
                            <li class="list-group-item"><div><a onclick="ticket.open('{{uuid}}')">{{event.title}} {{event.dateStart}}</a>
                                {{#if active}}
                                    ACTIVE
                                {{else}}
                                    NOT ACTIVE
                                {{/if}}</div></li>
                            {{/each}}
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    {{/each}}
</script>

</body>
</html>
