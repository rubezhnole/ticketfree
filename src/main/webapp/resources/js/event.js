function Event() {

    var that = this;
    this.eventId = null;

    this.init = function() {
        that.eventId = $("#eventId").val();

        $("#createEventButton").click(function () {
           that.create();
        });

        // $("#orderTicket").click(function() {
        //    that.order();
        // });
    };

    this.load = function() {
        $.ajax({
            type: "GET",
            url: "/event/load/" + that.eventId,
            success: function(resp) {
                var template = Handlebars.compile($("#eventTemplate").html());
                $("#eventContainer").html(template(resp));
            },
            error: function() {

            }
        })
    };

    this.getObj = function() {
        return {
            "title": $("#eventTitle").val(),
            "description": $("#eventDescription").val(),
            "venue": $("#eventVenue").val(),
            "dateStart": $("#dateStart").val(),
            "dateEnd": $("#dateEnd").val()
        }
    };

    this.create = function() {
        $.ajax({
            type: "POST",
            url: "/event/save",
            data: {
                json: JSON.stringify(that.getObj())
            },
            success: function(resp) {
                // open event page
            },
            error: function() {

            }
        })
    };

    this.order = function() {
        $.ajax({
            type: "GET",
            url: "/ticket/order",
            data: {
                number: $("#number").val(),
                eventId: that.eventId
            },
            success: function(resp) {

            },
            fail: function() {

            }
        })
    }
}