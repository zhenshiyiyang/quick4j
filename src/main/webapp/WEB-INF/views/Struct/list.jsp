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
<title>Insert title here</title>
</head>
<body >
	<div id="list" style="display: block;overflow:auto;width:100%;">
	    <input type="text" name="nameForMap" id="nameForMap" value="${name}" style="display:none"/>
		<table width="100%" border="0" cellpadding="7" cellspacing="0"
			class="table table-striped" id="list_t">
			<tr>
		    <c:forEach var="str" items="${columns}">
				<th  style="white-space: nowrap;text-align:center;">${str}</th>
			</c:forEach>
			</tr>
			<c:forEach var="list" items="${total_list}">
				<tr>
				<c:forEach var="list" items="${list}">
					<td align="center" style="white-space: nowrap;" >${list}</td>
				</c:forEach>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<!-- 分页功能 start -->
		<div align="center" id="page">
		<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
			${page.pageNow} 页</font> <a href="rest/search/searchByPage?pageNow=1" class='search_A'>首页</a>
		<c:choose>
			<c:when test="${page.pageNow - 1 > 0}">
				<a href="rest/search/searchByPage?pageNow=${page.pageNow - 1}"
			  class='search_A'>上一页</a>
			</c:when>
			<c:when test="${page.pageNow - 1 <= 0}">
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${page.totalPageCount==0}">
				<a href="rest/search/searchByPage?pageNow=${page.pageNow}"
					class='search_A'>下一页</a>
			</c:when>
			<c:when test="${page.pageNow + 1 <= page.totalPageCount}">
				<a href="rest/search/searchByPage?pageNow=${page.pageNow + 1}"
					class='search_A'>下一页</a>
			</c:when>
			<c:when test="${page.pageNow + 1 > page.totalPageCount}">
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${page.totalPageCount==0}">
				<a href="rest/search/searchByPage?pageNow=${page.pageNow}"
				class='search_A'>尾页</a>
			</c:when>
			<c:otherwise>
				<a href="rest/search/searchByPage?pageNow=${page.totalPageCount}"
				class='search_A'>尾页</a>
			</c:otherwise>
		</c:choose>
        </div>  
<!-- 分页功能 end -->  
      <script src="app/js/Struct/select.js" type="text/javascript"></script>
</body>
</html>