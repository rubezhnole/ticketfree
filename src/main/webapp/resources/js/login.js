function Login() {

    var that = this;

    this.init = function() {
      $("#logIn").click(function() {
         that.login();
      })
    };

    this.login = function() {
        $.ajax({
            type: "POST",
            url: "/login",
            data: {
                username: $("#inputUsername").val(),
                password: $("#inputPassword").val()
            },
            success: function(resp) {
                $("#content").html(resp);
            },
            error: function () {

            }
        })
    };

    this.register = function() {

    };
}