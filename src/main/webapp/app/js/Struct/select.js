$(function(){
    var database = {
        "test" : "test"
    };
    var selectTable = [];
    var selectAttrs = [];
    var selectModule = [];
    var sort = "";

    var i = 0;
    var selectArray = {};

    var searchCount = $("#searchCount").attr("value",searchCount);
    var comCount = 1;
    var boxCount = 1;
    var inputCount = 1;
    var attrboxCount = 1;

    var comTable = {
        "test" : "test"
    };

    var hash = {};
    var reHash = {};

    function JSONLength(obj) {
        var size = 0, key;
        for (key in obj) {
            if (obj.hasOwnProperty(key)) size++;
        }
        return size;
    };
    function createJson(json, prop, val) {
        if (typeof val === "undefined") {
            delete json[prop];
        } else {
            json[prop] = val;
        }
    }




    function appendSelect(splitArray) {
        $('#searchSelectTable tr:last td:nth-child(2) div ul').empty();

        for (i = 0; i < splitArray.length; i++) {
            if (splitArray[i] != "is_del") {
                var selectLi = "";
                selectLi += "<li><a>";
                selectLi += hash[splitArray[i]];
                selectLi += "</a></li>";
                $('#searchSelectTable tr:last td:nth-child(2) div ul').append(selectLi);
                //add attrselectshow


            }

        }






    }

    function appendSelectINI(splitArray) {
        var selectBox = "";
        $('#attrlist ').html("");
        selectBox += "<tr hidden='hidden'>";
        for (i = 0; i < splitArray.length; i++) {
            if (splitArray[i] != "is_del") {

                selectBox += "<td>";
                selectBox += "<input name='attrBox' type='checkbox' checked=true id='attrbox" ;
                selectBox += attrboxCount++;
                selectBox += "'/>";
                selectBox += "</td>";
                selectBox += "<td>" ;
                selectBox += hash[splitArray[i]];
                selectBox += "</td>";
                if((attrboxCount-1)%10==0)
                    selectBox += "</tr><tr hidden='hidden'>";

            }

        }
        $('#attrlist').append(selectBox);
    }

    function joinArr(arr){

        var temp = arr.join(',');

        $("#selectArray").attr("value",temp);
    }






    function removeByValue(arr, val) {
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                arr.splice(i, 1);
                joinArr(arr);//
                break;
            }
        }
    }

    //add

    $("#attrbtn").unbind('click').click(function() {
        if($("table[id$='list_t']>tbody").children("tr").eq(0).text()=="")
        {
            alert("请先执行查询操作！");
        }
        else{
            if($("#attrlist").attr("hidden")=="hidden")
            {
                $("#qx").removeAttr("hidden");

                $("#attrlist").removeAttr("hidden");
                $("#attrlist tr").removeAttr("hidden");}
            else
            {
                $("#qx").attr("hidden",true);

                $("#attrlist").attr("hidden",true);
                $("#attrlist tr").attr("hidden",true);


            }
        }

    });

    $('#pro_1').click(function() {
        $("#select_4_1").empty();
        createJson(database, "driver", $("#dbDriver").val())
        createJson(database, "url", dbUrl.value);
        createJson(database, "name", $('#dbName').val());
        createJson(database, "pwd", $('#dbPwd').val());

        $.ajax({
            type : "POST",
            url : "rest/search/getModuleName",
            dataType : "json",
            data : database,
            async : false,
            success : function(result) {
                if(result == ""){
                    alert("账号或者密码错误!");
                }else{
                    //console.log(result);
                    $('#c1a').text("数据库连接成功");
                    tableArray = result.toString().split(",");
                    appendSelect_2_1(tableArray, '#select_4_1');
                    div_1.style.display="none";
                    div_4.style.display="block";
                    div_2.style.display="none";
                    div_3.style.display="none";
                    $("#c1a").click();
                    $("#c4a").click();
                }
            },

        });


    });

    function appendSelect_2_1(splitArray, id) {
        for (i = 0; i < splitArray.length; i++) {
            var select = "";
            select += "<option id='";
            select += splitArray[i];
            select += "'>";
            select += splitArray[i];
            select += "</option>";
            $(id).append(select);
        }
    }

    function appendSelect_4_1(splitArray, id) {
        for (i = 0; i < splitArray.length; i++) {
            var select = "";
            select += "<option id='";
            select += splitArray[i];
            select += "'>";
            select += splitArray[i];
            select += "</option>";
            $(id).append(select);
        }
    }


    $("#pro_4_back").click(function(){
        $('#c1a').text("选择数据库");
        div_1.style.display="block";
        div_4.style.display="none";
        div_2.style.display="none";
        div_3.style.display="none";
        //simDiv.style.display="none";
        $("#c1a").click();
        $("#c4a").click();
    });
    $("#pro_2_back").click(function(){
        $('#c4a').text("选择模块类别");
        div_1.style.display="none";
        div_4.style.display="block";
        div_2.style.display="none";
        div_3.style.display="none";
        //simDiv.style.display="none";
        $("#c4a").click();
        $("#c2a").click();
    });

    $("#div_3_back").click(function(){
        $('#searchSelectTable tr td:nth-child(2) div button').attr("disabled",false);
        $("#qx").attr("hidden",true);
        $("#attrlist").attr("hidden",true);
        $("#attrlist tr").attr("hidden",true);
        $("table[id$='list_t']>tbody").children("tr").eq(0).children("th").eq(0).html("");
        $("#list_t").attr("hidden",true);
        $("#page").attr("hidden",true);
        //	alert($('#searchSelectTable tr').length);
        //	if($('#searchSelectTable tr:last td:nth-child(2) div button').text() != "查询条件" ||$('#searchSelectTable tr').length>3 ){
        var trList = $("table[id$='searchSelectTable']>tbody").children("tr");
        for(var i=2;i<trList.length;i++){
            trList.eq(i).remove();

        }
        searchCount=1;
        $("#searchCount").attr("value",searchCount);
        var temp = "";
        temp += "<tr>";
        temp += "<td class='td0'>";
        temp +=	"<input name='subBox' type='checkbox' id='box" ;
        temp += boxCount++;
        temp +=	"'/>";
        temp += "</td>";
        temp += "<td class='td1'><div class='dropdown'>" ;
        temp += "<button class='btn btn-default dropdown-toggle drop' type='button' id='dropdownMenu";
        temp += searchCount;
        temp += "' data-toggle='dropdown' aria-haspopup='true' aria-expanded='true'>";
        temp += "查询条件";
        temp += "<span class='caret'></span>";
        temp += "</button>";
        temp += "<ul class='dropdown-menu' aria-labelledby='dropdownMenu";
        temp += searchCount++;
        temp += "'>";
        temp += "</ul></div></td>";
        temp += "<td class='td2'><div style='display:none'>" ;
        temp +=	"<select class='div_1_input comsel' id='com";
        temp += comCount++;
        temp += "' style=\"width: 50px\">";
        temp += "<option value='max-'>" ;
        temp += "&gt;";
        temp += "</option>";
        temp += "<option value='min-'>" ;
        temp += "&lt;";
        temp += "</option>";
        temp += "<option value='equ-'>" ;
        temp += "=";
        temp += "</option>";
        temp += "</select ></div></td>";
        temp += "<td class='td3'><div>";
        temp += "<input type='text' size='20'  class='inpMain inp' id='input" ;
        temp += inputCount++;
        temp +=	"'/>";
        temp += "</div></td>";
        temp += "</tr>";

        $("#searchCount").attr("value",searchCount);
        $("#searchSelectTable").append(temp);
        //	}
        $('#c2a').text("选择查询的表");
        div_1.style.display="none";
        div_4.style.display="none";
        div_2.style.display="block";
        div_3.style.display="none";
        simDiv.style.display="none";
        $("#c2a").click();
        $("#c3a").click();
        selectAll();
    });

    $('#pro_4').click(function(){
        $("#select_2_1").empty();
        var selectValue = $('#select_4_1>option:selected').text();
        $('#c4a').text("模块："+selectValue);
        selectTable.push(selectValue);
        createJson(database, "module", selectValue);
        $.ajax({
            type:"POST",
            async : false,
            dataType:"json",
            url:"rest/search/getTableName",
            data:database,
            success:function(res){
                tableArray = res.toString().split(",");
                appendSelect_2_1(tableArray,'#select_2_1');
            }
        });
        div_1.style.display="none";
        div_4.style.display="none";
        div_2.style.display="block";
        div_3.style.display="none";
        simDiv.style.display="block";
        $("#c4a").click();
        $("#c2a").click();

    });

    $('#pro_2').click(function(){



        var selectValue = $('#select_2_1>option:selected').text();
        $('#c2a').text("表名："+selectValue);
        selectTable.push(selectValue);
        createJson(database, "db", selectValue);
        $.ajax({
            type:"POST",
            async : false,
            dataType:"json",
            url:"rest/search/getHash",
            data:database,
            success:function(data){
                $("#rehash").attr("value",data.toString());
                arr = data.toString().split(",");
                for(var i=0;i<arr.length;i++){
                    hash[arr[i]] = arr[i+1];
                    reHash[arr[i+1]] = arr[i];
                    i++;
                }
                console.log(reHash);
                console.log(hash);
                $.ajax({
                    type:"POST",
                    async : false,
                    dataType:"json",
                    url:"rest/search/getColumnName",
                    data:database,
                    success:function(res){
                        var trList = $("table[id$='searchSelectTable']>tbody").children("tr");
                        var count= trList.length;
                        while(count>3) {
                            $("#searchSelectTable tr:last").remove();
                            count--;
                        }

                        selectArray = res.toString().split(",");
                        joinArr(selectArray);//
                        appendSelect(selectArray);
                        appendSelectINI(selectArray);
                    }
                });

            }

        });


        div_1.style.display="none";
        div_4.style.display="none";
        div_2.style.display="none";
        div_3.style.display="block";
        simDiv.style.display="block";
        $("#c2a").click();
        $("#c3a").click();
    });


    $("#dbDriver").change(function(){
        if(dbDriver.value=="mysql"){
            dbUrl.value="jdbc:mysql://219.216.64.94:3306/FISHERY";
            dbName.value="root";
            dbPwd.value="root";
        }else if(dbDriver.value=="oracle"){
            //database.value="";
            dbUrl.value="jdbc:mysql://219.216.64.94:3306/FISHERY";
            dbName.value="root";
            dbPwd.value="root";
        }else{
            dbUrl.value="";
            dbName.value="";
            dbPwd.value="";
        }
    });






    $("#addSearch")[0].onclick = function() {
        searchCount=$("#searchCount").attr("value");
        //	var res = $("#selectArray").attr("value");//记录selectArray
        //	selectArray = res.toString().split(",");
        var res = $("#selectArray").attr("value");//记录selectArray

        var selectArray = res.toString().split(",");
        //   alert(res);
        var re = $("#rehash").attr("value");
        var arrt = re.toString().split(",");
        for(var i=0;i<arrt.length;i++){
            hash[arrt[i]] = arrt[i+1];
            reHash[arrt[i+1]] = arrt[i];
            i++;
        }


        //	alert(selectArray.length);
        if(searchCount <= JSONLength(hash)){
            if($('#searchSelectTable tr:last td:nth-child(2) div button').text() != "查询条件"){
                var text = reHash[$('#searchSelectTable tr:last td:nth-child(2) div button').text()];
                $('#searchSelectTable tr td:nth-child(2) div button');

                removeByValue(selectArray, text);
                var temp = "";
                temp += "<tr>";
                temp += "<td class='td0'>";
                temp +=	"<input name='subBox' type='checkbox' id='box" ;
                temp += boxCount++;
                temp +=	"'/>";
                temp += "</td>";
                temp += "<td class='td1'><div class='dropdown'>" ;
                temp += "<button class='btn btn-default dropdown-toggle drop' type='button' id='dropdownMenu";
                temp += searchCount;
                temp += "' data-toggle='dropdown' aria-haspopup='true' aria-expanded='true'>";
                temp += "查询条件";
                temp += "<span class='caret'></span>";
                temp += "</button>";
                temp += "<ul class='dropdown-menu' aria-labelledby='dropdownMenu";
                temp += searchCount++;
                temp += "'>";
                temp += "</ul></div></td>";
                temp += "<td class='td2'><div style='display:none'>" ;
                temp +=	"<select class='div_1_input comsel' id='com";
                temp += comCount++;
                temp += "' style=\"width: 50px\">";
                temp += "<option value='max-'>" ;
                temp += "&gt;";
                temp += "</option>";
                temp += "<option value='min-'>" ;
                temp += "&lt;";
                temp += "</option>";
                temp += "<option value='equ-'>" ;
                temp += "=";
                temp += "</option>";
                temp += "</select ></div></td>";
                temp += "<td class='td3'><div>";
                temp += "<input type='text' size='20'  class='inpMain inp' id='input" ;
                temp += inputCount++;
                temp +=	"'/>";
                temp += "</div></td>";
                temp += "</tr>";


                $("#searchSelectTable").append(temp);
                appendSelect(selectArray);

                $("#searchCount").attr("value",searchCount);

                $('#checkAll').prop("checked",false);
            }else{
                alert("请您填写完整上一条查询后，再添加新的查询条件，谢谢。");
            }
        }else{
            //alert("您不能添加更多的查询条件了=。=")
        }


    }
//属性全选，全不选,隐藏null列
    $("#all").click(function() {//全选
        $('input[name="attrBox"]').prop("checked",true);
        $("#list_t").removeAttr("hidden");
        var trList1 = $("table[id$='list_t']>tbody").children("tr");
        var trList2 = $("table[id$='list_t']>tbody").children("tr").eq(0).children("th");

        for (var i=0;i<trList2.length;i++) {

            trList2.eq(i).removeAttr("hidden");
            for(var j=1;j<trList1.length;j++)
            {
                trList1.eq(j).children("td").eq(i).removeAttr("hidden");

            }



        }

    });
    $("#non").click(function() {//全不选
        $('input[name="attrBox"]').prop("checked",false);
        //$("#list_t").prop("hidden",true);
        var trList1 = $("table[id$='list_t']>tbody").children("tr");
        var trList2 = $("table[id$='list_t']>tbody").children("tr").eq(0).children("th");

        for (var i=0;i<trList2.length;i++) {

            trList2.eq(i).attr("hidden",true);
            for(var j=1;j<trList1.length;j++)
            {
                trList1.eq(j).children("td").eq(i).attr("hidden",true);

            }



        }
    });

    $("#nul").unbind("click").bind("click",function() {//隐藏null
        if(	$("#nul").val()=="隐藏空列"){

            var trList2 = $("table[id$='list_t']>tbody").children("tr").eq(0).children("th");
            var trList1 = $("table[id$='list_t']>tbody").children("tr");

            for (var i=0;i<trList2.length;i++) {
                var tag=0;
                //	trList2.eq(i).attr("hidden",true);
                for(var j=1;j<trList1.length;j++)
                {
                    //		alert(trList1.eq(j).children("td").eq(i).text());
                    if(trList1.eq(j).children("td").eq(i).text()=="")
                        tag++;


                }

                if(tag==trList1.length-1)
                {
                    trList2.eq(i).attr("hidden",true);

                    for(var k=1;k<trList1.length;k++)
                    {
                        trList1.eq(k).children("td").eq(i).attr("hidden",true);

                    }
                    //去掉勾选
                    $('input[name="attrBox"]').each(function(){

                        if($(this).parent().next('td').text()==trList2.eq(i).text())
                            $(this).prop("checked",false);

                    });
                    //改变button值
                    $("#nul").val("显示空列");
                }

            }

        }
        else{

            var trList2 = $("table[id$='list_t']>tbody").children("tr").eq(0).children("th");
            var trList1 = $("table[id$='list_t']>tbody").children("tr");

            for (var i=0;i<trList2.length;i++) {
                var tag=0;
                //	trList2.eq(i).attr("hidden",true);
                for(var j=1;j<trList1.length;j++)
                {
                    //		alert(trList1.eq(j).children("td").eq(i).text());
                    if(trList1.eq(j).children("td").eq(i).text()=="")
                        tag++;


                }

                if(tag==trList1.length-1)
                {
                    trList2.eq(i).removeAttr("hidden");

                    for(var k=1;k<trList1.length;k++)
                    {
                        trList1.eq(k).children("td").eq(i).removeAttr("hidden");

                    }
                    //去掉勾选
                    $('input[name="attrBox"]').each(function(){

                        if($(this).parent().next('td').text()==trList2.eq(i).text())
                            $(this).prop("checked",true);

                    });
                    //改变button值
                    $("#nul").val("隐藏空列");
                }

            }





        }

        //	$('input[name="attrBox"]').prop("checked",false);
        //$("#list_t").prop("hidden",true);




    });



//全选
    $("#checkAll").click(function() {//全选
        $('input[name="subBox"]').prop("checked",this.checked);
    });

    function selectAll(){

        var allLength=0;
        var selectedLength=0;
        $("input[name='subBox']").each(function(){
            allLength++; //所有的checkbox的长度
            if($(this).prop("checked")==true)
                selectedLength++;//所有的选中的checkbox的长度
        });

        if(selectedLength == allLength){
            $('#checkAll').prop("checked",true);//全选按钮选中
        }else{
            $('#checkAll').prop("checked",false);//全选按钮不选中
        }

    }
    $('#searchSelectTable').on("click","tr td input",function (){
        selectAll();
    });

    //属性显示隐藏

    $('#attrlist tr td input').on("click",function (){

        var attrr=$(this).parent().next('td').text();
        var trList1 = $("table[id$='list_t']>tbody").children("tr");
        var trList2 = $("table[id$='list_t']>tbody").children("tr").eq(0).children("th");

        for (var i=0;i<trList2.length;i++) {

            var talias1 = trList2.eq(i).text();

            if(talias1==attrr)
            {
                if($(this).prop("checked")==true)
                {

                    trList2.eq(i).removeAttr("hidden");
                    for(var j=1;j<trList1.length;j++)
                    {
                        trList1.eq(j).children("td").eq(i).removeAttr("hidden");

                    }


                }
                else{
                    trList2.eq(i).attr("hidden",true);
                    for(var k=1;k<trList1.length;k++)
                    {
                        trList1.eq(k).children("td").eq(i).attr("hidden",true);

                    }
                }
            }
        }
    });




    $("#delAll")[0].onclick = function() {
        var chk=0;
        var all=0;
        var reHash = {};
        var rehash = $('#rehash').attr("value");

        var arr1 = rehash.toString().split(",");

        var res = $("#selectArray").attr("value");//记录selectArray
        //alert(res);
        var selectArray = res.toString().split(",");



        for(var i=0;i<arr1.length;i++){

            reHash[arr1[i+1]] = arr1[i];
            i++;
        }
        $("input[name='subBox']").each(function(){
            all++; //所有的长度
            if($(this).prop("checked")==true)
                chk++;//所有的选中的checkbox的长度
        });
        //selectArray.push(reHash[$('#searchSelectTable tr:last td:first div button').text()]);
        if(all-chk>0){
            $("input[name='subBox']").each(function(){

                if($(this).prop("checked")==true)
                {
                    if($(this).parent().parent().children('td').eq(1).find('button').attr())
                        selectArray.push(reHash[$(this).parent().parent().children('td').eq(1).find('button').text()]);

                    joinArr(selectArray);

                    $(this).parent().parent().remove();
                    searchCount=$("#searchCount").attr("value");
                    //			alert(searchCount=$("#searchCount").attr("value"));
                    searchCount--;
                    //			$('#searchSelectTable tr:last td:nth-child(2) div button').removeAttr("disabled");
                    $("#searchCount").attr("value",searchCount);
                }
            });


        }
        else{
            searchCount=$("#searchCount").attr("value");
            while(searchCount>2)
            {
                if($('#searchSelectTable tr:last td:nth-child(2) div button').attr())
                    selectArray.push(reHash[$('#searchSelectTable tr:last td:nth-child(2) div button').text()]);

                joinArr(selectArray);

                $("#searchSelectTable tr:last").remove();
                searchCount--;
                $("#searchCount").attr("value",searchCount);
            }
            //	$('#searchSelectTable tr:last td:first div button ').attr("text","查询条件");
            alert("您必须保留至少一条查询条件 ：）");
        }
        selectAll();
    }

    $("#removeSearch")[0].onclick = function() {
        var rehash = $('#rehash').attr("value");
        var reha = {};
        var arr2 = rehash.toString().split(",");
        //	alert(arr2.length);

        var res = $("#selectArray").attr("value");//记录selectArray
        //	alert(res);
        var selectArray = res.toString().split(",");


        for(var i=0;i<arr2.length;i++){

            reha[arr2[i+1]] = arr2[i];
            i++;
        }

        searchCount=$("#searchCount").attr("value");
        //	alert(searchCount);
        if(searchCount == 2){
            alert("您必须保留至少一条查询条件 ：）");
        }else{
            //	alert(reha[$('#searchSelectTable tr:last td:nth-child(2) div button').text()]);
            //	alert($('#searchSelectTable tr:last td:nth-child(2) div button').attr("disabled"));
            if($('#searchSelectTable tr:last td:nth-child(2) div button').attr())
                selectArray.push(reha[$('#searchSelectTable tr:last td:nth-child(2) div button').text()]);


            joinArr(selectArray);


            $("#searchSelectTable tr:last").remove();

            //	$('#searchSelectTable tr:last td:nth-child(2) div button').removeAttr("disabled");
            searchCount--;

            $("#searchCount").attr("value",searchCount);

        }

        selectAll();
    }

    $('#searchSelectTable').on('blur','tr td div input',function(){

        if($(this).parent().parent().prev().find('div').css("display").indexOf("block")>=0)
        {

            var patrn = /^(-)?\d+(\.\d+)?$/;
            if (patrn.exec($(this).val()) == null ) {
                alert("请输入数字");
                $(this).val("");

            }
        }
        /*	if ($('#searchSelectTable tr:last td:first div button').text().replace(/(^\s*)|(\s*$)/g, '') != "Dropdown") {
                if (reHash[$(this).parent().parent().find('button').text()] != "undefined") {
                    var key = reHash[$(this).parent().parent().find('button').text()];
                }else{
                    var key = $(this).parent().parent().find('button').text();
                }

                if ($('#searchSelectTable tr:last').children('td').eq(1).find('div').css("display")=="block")
                    {
                    var value = $('#searchSelectTable tr:last').children('td').eq(1).find('div').find('select').val()+ $(this).val();
                    }
                else
                   var value = $(this).val();

                createJson(json, key, value);
                createJson(json, "test");
        //	alert("1"+key);*/

    });


    $('#searchSelectTable').on("click","tr td div ul a",function(e) {
        e.preventDefault();
        if(reHash=={}){

            var rehash = $('#rehash').attr("value");

            var arr1 = rehash.toString().split(",");
            for(var i=0;i<arr1.length;i++){

                hash[arr[i]] = arr[i+1];
                reHash[arr[i+1]] = arr[i];
                i++;
            }
        }

        var text = reHash[$(this).text()];
        /*	$(this).parent().parent().parent().find('button').text(hash[text]);
            testArry();
            removeByValue(selectArray, text);*///逻辑有问题
//add
        $(this).parent().parent().parent().find('button').text(hash[text]);

        var selt = $('#select_2_1>option:selected').text();
        var sela = $(this).parent().parent().parent().find('button').text();
        var d;

        createJson(comTable, "at", sela);
        createJson(comTable, "table", selt);
        createJson(comTable, "test");

        $.ajax({
            type : "POST",
            async : false,
            url:"rest/search/getType",
            data : comTable,
            success : function(data) {

                d=data;

            }
        });
        if(d=="0")
            $(this).closest('tr').children('td').eq(2).find('div').css("display", "none");
        if(d=="1")
        {

            $(this).closest('tr').children('td').eq(2).find('div').css("display","block"); }

    });

//add
    /*	$("#searchSelectTable tr:last td:nth-child(2) div select").bind("change",function(){

              if($('#searchSelectTable tr:last').children('td').eq(2).find('input').val()!=""){
                  if (reHash[$('#searchSelectTable tr:last').children('td').eq(0).find('button').text()] != "undefined") {
                        var key = reHash[$('#searchSelectTable tr:last').children('td').eq(0).find('button').text()];
                    }else{
                        var key = $('#searchSelectTable tr:last').children('td').eq(0).find('button').text();
                    }

                        var value = $('#searchSelectTable tr:last').children('td').eq(1).find('div').find('select').val() + $('#searchSelectTable tr:last').children('td').eq(2).find('input').val();

                    createJson(json, key);
                    createJson(json, key, value);

                }

            });
    */


    $('#chaxun').unbind("click").bind("click",function(){
        //	$('#searchSelectTable tr td:nth-child(2) div button').attr("disabled",false);
        $('#bkim').css("display","none");
        var json = {
            "test" : "test"
        };
        var reHash = {};
        var hash = {};
        createJson(json, "test");

        var rehash = $('#rehash').attr("value");

        var arr1 = rehash.toString().split(",");
        for(var i=0;i<arr1.length;i++){

            reHash[arr1[i+1]] = arr1[i];



            i++;
        }

        //var trList = $("#searchSelectTable").children('tr');
        var trList = $("table[id$='searchSelectTable']>tbody").children("tr");

        for (var i=2;i<trList.length;i++) {

            var talias = trList.eq(i).children('td').eq(1).find('div').find('button').text();

            var tin = trList.eq(i).children('td').eq(3).find('div').find('input').val();



            if (talias.replace(/(^\s*)|(\s*$)/g, '') != "Dropdown") {
                if (reHash[talias] != "undefined") {
                    var key = reHash[talias];

                }else{
                    var key = talias;

                }

                if (trList.eq(i).children('td').eq(2).find('div').css("display")=="block")
                {
                    var tcom =  trList.eq(i).children('td').eq(2).find('div').find('select').val();
                    var value = tcom + tin;
                }
                else
                    var value = tin;

                createJson(json, key, value);

            }
        }



        $('#jsonInput').val("").val(JSON.stringify(json));
        $('#jumpTmp').val("");
        $.ajax({
            type : "POST",
            dataType : "html",
            async : false,
            url : "rest/search/query",
            data : json,
            success : function(data) {
                $('#listAll').html(data);
            }
        });
    });

    $('#page a').click(function(e){
        e.preventDefault();
        var url = this.href;
        $.get(url, function(data) {
            $('#listAll').html(data);
        });
    });
    $("#down").click(function() {
        $.ajax({
            type:"POST",
            async : false,
            url:"rest/search/poi",
            data:database,
            success:function(res){
                console.log(res);
                //$("#download").onclick();
                window.location.href="rest/search/down";
            }
        });
    });
});

//翻页属性控制
$("#list_t").ready(function (){
    //遍历

    var attrnames=new Array();
    var count=0;
    var alt=0;
    $("input[name='attrBox']").each(function(){
        alt=1;
        //所有的checkbox的长度
        if($(this).prop("checked")==true)
        {
            attrnames[count]=$(this).parent().next('td').text();

            count++;

        }

    });

    if(count!=0||alt==1){

        var trList1 = $("table[id$='list_t']>tbody").children("tr");
        var trList2 = $("table[id$='list_t']>tbody").children("tr").eq(0).children("th");
        if(count==0)
        {

            for (var l=0;l<trList2.length;l++) {

                trList2.eq(l).attr("hidden",true);
                for (var m=1;m<trList1.length;m++)
                {
                    trList1.eq(m).children("td").eq(l).attr("hidden",true);

                }
            }

        }


        else{
            for (var i=0;i<trList2.length;i++) {

                for (var j=0;j<count;j++)
                {
                    if(trList2.eq(i).text()==attrnames[j])
                    {


                        trList2.eq(i).removeAttr("hidden");


                        for (var k=1;k<trList1.length;k++)
                        {
                            trList1.eq(k).children("td").eq(i).removeAttr("hidden");
                        }
                        break;
                    }
                    else{

                        trList2.eq(i).attr("hidden",true);
                        for (var c=1;c<trList1.length;c++)
                        {
                            trList1.eq(c).children("td").eq(i).attr("hidden",true);

                        }
                    }
                }
            }
        }

    }

});