function Event() {

    var that = this;
    this.eventId = null;

    this.init = function() {
        that.eventId = $("#eventId").val();
    };

    this.toObj = function(palace) {
        return {
            "": $()
        }
    };

    this.load = function() {
        $.ajax({
            type: "POST",
            url: "/event/load/" + that.eventId,
            success: function(resp) {
                var template = Handlebars.compile($("#eventTemplate").html());
                $("#eventContainer").html(template(resp));
            },
            error: function() {

            }
        })
    }
}