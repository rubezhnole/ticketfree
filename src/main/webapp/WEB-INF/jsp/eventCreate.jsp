<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/handlebars.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript" src="/resources/js/datetimepicker.js"></script>

    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/datetimepicker.css" rel="stylesheet">
</head>
<body>

<input type="hidden" id="eventId" value="${eventId}">

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
                <li><a href="#">Home</a></li>
                <li class="active"><a href="/event/create" target="_blank">Create Event</a></li>
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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="list-group form-group">
                <li class="list-group-item"><input class="form-control input-sm" id="eventTitle" type="text" placeholder="Title"/></li>
                <li class="list-group-item"><input class="form-control input-sm" id="eventDescription" type="text" placeholder="Description"/></li>
                <li class="list-group-item"><input class="form-control input-sm" id="eventVenue" type="text" placeholder="Venue"/></li>
                <li class="list-group-item"><input class="form-control input-sm datetimepicker"  id="dateStart" type="text" placeholder="Date start"/></li>
                <li class="list-group-item"><input class="form-control input-sm datetimepicker" id="dateEnd" type="text" placeholder="Date end"/></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <button id="createEventButton">Create</button>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
    </div>
</footer>

<script>

    $(function() {
        var event = new Event();
        event.init();

        $(".datetimepicker").datetimepicker({
            format: 'd-m-Y H:i',
            formatTime:'H:i',
            formatDate:'d.m.Y',
            lang: 'uk'
        });
    })
</script>


</body>
</html>
