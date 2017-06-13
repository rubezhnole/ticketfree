function EventForUser() {

    var that = this;
    this.eventId = null;

    this.init = function () {
        that.eventId = $("#eventId").val();


        /*  $("#createEventButton").click(function () {
         that.create();
         });*/

        // $("#orderTicket").click(function() {
        //    that.order();
        // });
    };

    this.loadForUserData = function() {
        $.ajax({
            type: "POST",
            url: "/event/loadForUserData",
            dataType: "json",
            success: function(resp) {

                var template = Handlebars.compile($("#eventTemplate").html());
                $("#eventContainer").html(template(resp));

                console.log(resp);

                $(".datetimepicker").datetimepicker({
                    format: 'd-m-Y H:i',
                    formatTime:'H:i',
                    formatDate:'d.m.Y',
                    lang: 'uk'
                });
            },
            error: function() {

            }
        })

    };

    this.update = function() {

    };
}