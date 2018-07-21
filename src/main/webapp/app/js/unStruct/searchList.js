$(document).ready(function() {
    $('#searchPage a').click(function(e){
        e.preventDefault();
        var url = this.href;
        $.get(url, function(data) {
            $('#listAll').html(data);
        });
    });
    $('.search_A').click(function(e){
        e.preventDefault();
        var url = this.href;
        $.get(url, function(data) {
            $('#listAll').html(data);
        });
    });
});