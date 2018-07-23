$(document).ready(function() {
    $('#searchPage a').click(function(e){
        e.preventDefault();
        var url = this.href;
        var wenjianming = $("#wenjianming").val();
        var zuozhe = $("#zuozhe").val();
        var laiyuan = $("#laiyuan").val();
        var leixing = $("#leixing").val();
        var kaishiriqi = $("#kaishiriqi").val();
        var jieshuriqi = $("#jiezhiriqi").val();
        var json = {
            "wenjianming": wenjianming,
            "zuozhe": zuozhe,
            "laiyuan": laiyuan,
            "leixing": leixing,
            "kaishiriqi": kaishiriqi,
            "jieshuriqi": jieshuriqi
        };
        $('#jsonInput').val(JSON.stringify(json));
        $.ajax({
            type: "POST",
            dataType: "html",
            async: false,
            url: url,
            data: json,
            success: function (data) {
                $('#listAll').html(data);
            }
        });
    });
    $('.search_A').click(function(e){
        e.preventDefault();
        var url = this.href;
        var wenjianming = $("#wenjianming").val();
        var zuozhe = $("#zuozhe").val();
        var laiyuan = $("#laiyuan").val();
        var leixing = $("#leixing").val();
        var kaishiriqi = $("#kaishiriqi").val();
        var jieshuriqi = $("#jiezhiriqi").val();
        var json = {
            "wenjianming": wenjianming,
            "zuozhe": zuozhe,
            "laiyuan": laiyuan,
            "leixing": leixing,
            "kaishiriqi": kaishiriqi,
            "jieshuriqi": jieshuriqi
        };
        $('#jsonInput').val(JSON.stringify(json));
        $.ajax({
            type: "POST",
            dataType: "html",
            async: false,
            url: url,
            data: json,
            success: function (data) {
                $('#listAll').html(data);
            }
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
                    var url_new = "rest/meta/search";
                    var wenjianming = $("#wenjianming").val();
                    var zuozhe = $("#zuozhe").val();
                    var laiyuan = $("#laiyuan").val();
                    var leixing = $("#leixing").val();
                    var kaishiriqi = $("#kaishiriqi").val();
                    var jieshuriqi = $("#jiezhiriqi").val();
                    var json = {
                        "wenjianming": wenjianming,
                        "zuozhe": zuozhe,
                        "laiyuan": laiyuan,
                        "leixing": leixing,
                        "kaishiriqi": kaishiriqi,
                        "jieshuriqi": jieshuriqi
                    };
                    $('#jsonInput').val(JSON.stringify(json));
                    $.ajax({
                        type: "POST",
                        dataType: "html",
                        async: false,
                        url: url_new,
                        data: json,
                        success: function (result) {
                            $('#listAll').html(result);
                        }
                    });
                }else{
                    alert("删除失败");
                }
            });
        }
    });
});