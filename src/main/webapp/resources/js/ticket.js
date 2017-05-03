function Ticket() {

    var that = this;
    this.userId = null;

    this.init = function() {
        this.userId = $("#userId").val();
    };

    this.load = function() {
        $.ajax({
            type: "GET",
            url: "/ticket/loadByUser",
            data: {
                userId: that.userId
            },
            success: function(json) {
                var template = Handlebars.compile($("#ticketTemplate").html());
                $("#ticketContainer").html(template(json))
            },
            fail: {

            }
        })
    };

    this.open = function(uuid) {
        window.open("/ticket/loadTicket?uuid=" + uuid, "_blank");
    };
}