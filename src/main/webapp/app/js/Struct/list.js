$(function() {
    $('#page a').click(function(e){
        e.preventDefault();
        var url = this.href;
        $.get(url, function(data) {
            $('#listAll').html(data);
        });
    });
});