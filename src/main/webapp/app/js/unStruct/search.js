$(document).ready(function() {
    $('#chaxun').click(function(e){
        e.preventDefault();
        var url = "rest/meta/search";
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
});