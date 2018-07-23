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
    $('.deleteButton').click(function(e){
        e.preventDefault();
        var url = this.href;
        flag = window.confirm("确定要删除该信息？");
        if(flag==false)
        {
            return false;
        }else{
            $.get(url, function(data) {
                if(data=="success"){
                    alert("删除成功");
                    var new_url = "rest/meta/list";
                    $.get(new_url, function(result) {
                        $('#listAll').html(result);
                    });
                }else{
                    alert("删除失败");
                }
            });
        }
    });
});