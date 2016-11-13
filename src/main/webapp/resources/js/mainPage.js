function MainPage() {

    var that = this;

    this.init = function () {
        $("#searchButton").on("click", function() {
            that.search();
        });
    };

    this.search = function() {
        var searchText = $("#searchText").val();
        if (0 == searchText.length) {
            return false;
        }

        $.ajax({
            type: "GET",
            url: "/search",
            data: {
                searchText: searchText
            },
            success: function(resp) {
                var template = Handlebars.compile($("#searchResultTemplate").html());
                $("#searchResult").html(template(resp))
            },
            error: function() {

            }
        })

    }
}