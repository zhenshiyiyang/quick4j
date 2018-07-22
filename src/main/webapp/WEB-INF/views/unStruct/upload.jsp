<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>非结构化数据上传</title>
	<link rel="stylesheet" type="text/css" href="app/css/qmp/qmp.css" >
    <script type="text/javascript" src="app/js/uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#uploadify").uploadify({
    			'debug'     : false, //开启调试
    	        'auto'           : false, //是否自动上传
    	        'swf'            : 'app/js/uploadify/uploadify.swf',  //引入uploadify.swf
    	        'uploader'       : 'rest/meta/save',//请求路径
    	        'queueID'        : 'fileQueue',//队列id,用来展示上传进度的
    	        'width'     : '75',  //按钮宽度
    	        'height'    : '24',  //按钮高度
    	        'queueSizeLimit' : 10,  //同时上传文件的个数
    	        'fileTypeDesc'   : '视频文件',    //可选择文件类型说明

    	        'multi'          : true,  //允许多文件上传
    	        'buttonText'     : '选择文件',//按钮上的文字
    	        'fileSizeLimit' : '20000MB', //设置单个文件大小限制
    	        'fileObjName' : 'uploadify',  //<input type="file"/>的name
    	        'method' : 'post',
    	        'removeCompleted' : true,//上传完成后自动删除队列
    	        'onUploadStart' : function(file) {
    	        	var zuozhe = $("#zuozhe").val();
    	    		var laiyuan = $("#laiyuan").val();
    	    		var zhuti = $("#zhuti option:selected").val();
    	            $("#uploadify").uploadify("settings", "formData",{'zuozhe':zuozhe,'laiyuan':laiyuan,'zhuti':zhuti});
    	        },
    	        'onFallback':function(){
    	            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
    	        },
    	        'onUploadSuccess' : function(file, data, response){//单个文件上传成功触发
                    //data就是action中返回来的数据
					if(data=="success"){
						alert("文件上传成功");
					}else{
					    alert("文件上传失败");
					}
    	        },'onQueueComplete' : function(){//所有文件上传完成
    	        	$("#zuozhe").val("");
    	        	$("#laiyuan").val("");
    	        	$("#zhuti").val("未选");
    	        	//alert("文件上传成功!");
    	       		}
    	        });
    	});
    </script>
</head>
<body>
<div id="all">
    <div id="listAll">
        <!--<div id="left">-->
            <div>
               <table table width="100%" border="0" cellpadding="7" cellspacing="0"
					  class="tableBasic" id="list_t">
               			<tr>
               				<td align="left" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">作者:</td>
               				<td align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white"><input type="text" id = "zuozhe" name="zuozhe">
               				</td>
               			</tr>
               			<tr>
               				<td align="" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">来源:</td>
               				<td align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white"><input type="text" id = "laiyuan" name="laiyuan">
               				</td>
               			</tr>
               			<tr>
               				<td align="" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">主题:</td>
               				</td>
               				<td align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">
               				<select id="zhuti" name="zhuti">
               						<option value="未选">全部主题</option>
               						<option value="文本">文本</option>
               						<option value="图片">图片</option>
               						<option value="音频">音频文件</option>
               						<option value="视频">视频文件</option>
               				</select>
               				</td>
               			</tr>
				        <td align="" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">
								<input type="file" id="uploadify" name="uploadify" style="padding-left: 700px;">
								<div id="fileQueue"></div>
						</td>
				        <tr>
							<td align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">
								<a href="javascript:$('#uploadify').uploadify('upload','*')"><font size="3">开始上传</font></a>
							</td>
							<td align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">
								<a href="javascript:$('#uploadify').uploadify('cancel','*')"><font size="3">取消上传</font></a>
							</td>
						</tr>
               	</table>
            <!--</div>-->
        </div>
    </div>
</div>
</body>
</html>