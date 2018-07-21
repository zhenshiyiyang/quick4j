<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据检索</title>
	<link rel="stylesheet" type="text/css" href="app/css/qmp/public.css">
	<link rel="stylesheet" type="text/css" href="app/css/qmp/qmp.css">
	<script type="text/javascript" src="app/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="all">
	<div id="up">
		<table width="100%" border="0" cellpadding="7" cellspacing="0" class="tableBasic" id="search_cond">
			<tr>
				<td align="center" style="white-space: nowrap;">文件名:</td>
				<td align="center" style="white-space: nowrap;"><input type="text" id = "wenjianming" name="wenjianming" value="" ></td>
				<td align="center" style="white-space: nowrap;">作者:</td>
				<td align="center" style="white-space: nowrap;"><input type="text" id = "zuozhe" name="zuozhe" value="" ></td>
				<td align="center" style="white-space: nowrap;">
					开始日期：
					<input id = "kaishiriqi" name="kaishiriqi" class="Wdate" readonly="readonly" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
					截至日期：<input id = "jiezhiriqi" name="jiezhiriqi" class="Wdate" readonly="readonly" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
				</td>
			</tr>
			<tr>
				<td align="center" style="white-space: nowrap;">来源:</td>
				<td align="center" style="white-space: nowrap;"><input type="text" id = "laiyuan" name="laiyuan" value="" ></td>
				<td align="center" style="white-space: nowrap;">文件类型:</td>
				<td align="center" style="white-space: nowrap;">
					<select id="leixing" name="leixing">
						<option value="" selected="">全部文件类型</option>
						<option value="文本">文本</option>
						<option value="图片">图片</option>
						<option value="音频">音频文件</option>
						<option value="视频">视频文件</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="20" align="center"><input id="chaxun" type="button"  value="查询" class="btn btn-primary"></td>
			</tr>
		</table>
	</div>
	<div id="down">
		<div id="listAll"></div>
	</div>
</div>
<script type="text/javascript" src="app/js/unStruct/search.js"></script>
</body>
</html>