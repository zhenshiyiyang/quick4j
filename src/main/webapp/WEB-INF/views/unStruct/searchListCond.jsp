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
    <link rel="stylesheet" type="text/css" href="app/css/qmp/qmp.css" >
</head>
<body>
<div id="list" style="display: block;overflow:auto;width:100%;">
    <input type="text" name="nameForMap" id="nameForMap" value="${name}" style="display:none"/>
    <table width="100%" border="0" cellpadding="7" cellspacing="0"
           class="tableBasic" id="list_t">
        <tr>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">文件名</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">创建日期</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">作者</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">主题</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">类型</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">大小</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">来源</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">格式</th>
            <th align="center" style="white-space: nowrap;text-align: center;background:#99A4AF;color:white">操作</th>
        </tr>
        <c:forEach var="meta" items="${mlist}">
            <tr id="">
                <td align="center" style="white-space: nowrap;">${meta.timing}</td>
                <td align="center" style="white-space: nowrap;">${meta.riqi}</td>
                <td align="center" style="white-space: nowrap;">${meta.zuozhe}</td>
                <td align="center" style="white-space: nowrap;">${meta.zhuti}</td>
                <td align="center" style="white-space: nowrap;">${meta.leixing}</td>
                <td align="center" style="white-space: nowrap;">${meta.daxiao}</td>
                <td align="center" style="white-space: nowrap;">${meta.laiyuan}</td>
                <td align="center" style="white-space: nowrap;">${meta.geshi}</td>
                <td align="center" style="white-space: nowrap;">
                    <a href="rest/meta/id?id="
                       class="updateButton" style="color: white;background:#FAAD5E;padding:2px 6px">下载</a>
                    <a href="rest/meta/delete?id="
                       class="deleteButton" style="color: white;background:#00C0BF;padding:2px 6px">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- 分页功能 start -->
<div align="center" id="searchPage">
    <font size="2">共 ${page.totalPageCountMeta} 页</font> <font size="2">第
    ${page.pageNow} 页</font> <a href="rest/meta/search?pageNow=1"
                                class='search_A'>首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="rest/meta/search?pageNow=${page.pageNow - 1}"
               class='search_A'>上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCountMeta==0}">
            <a href="rest/meta/search?pageNow=${page.pageNow}"
               class='search_A'>下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 <= page.totalPageCountMeta}">
            <a href="rest/meta/search?pageNow=${page.pageNow + 1}"
               class='search_A'>下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 > page.totalPageCountMeta}">
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCountMeta==0}">
            <a href="rest/meta/search?pageNow=${page.pageNow}"
               class='search_A'>尾页</a>
        </c:when>
        <c:otherwise>
            <a href="rest/meta/search?pageNow=${page.totalPageCountMeta}"
               class='search_A'>尾页</a>
        </c:otherwise>
    </c:choose>
    <script>
    </script>
</div>
<script type="text/javascript" src="app/js/unStruct/searchListCond.js"></script>
</body>
</html>