<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2021/4/6
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/users/toSaleList" method="post">
        <input type="hidden" name="currentPage" value="1">
        <input type="hidden" name="limit" value="4">
        <strong>销售信息查询</strong>
        <div>
            <label for="order">排序方式</label>
            <select name="order" id="order">
                <option ${order == "sale_date" ? "selected" : ''} value="sale_date">销售日期</option>
                <option ${order == "price" ? "selected" : ''} value="price">单笔总价</option>
            </select>
            <input type="submit" value="查询">
        </div>

        <div>
            <table border="2">
                <tr>
                    <th>ID</th>
                    <th>商品</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>销售日期</th>
                    <th>销售员</th>
                </tr>
                <c:forEach var="data" items="${pageSupport.plist}">
                    <tr>
                        <td>${data.id}</td>
                        <td>${data.productName}</td>
                        <td>${data.price}</td>
                        <td>${data.quantity}</td>
                        <td>${data.totalPrice}</td>
                        <td><fmt:formatDate value="${data.saleDate}" type="DATE" pattern="yyyy-MM-dd"/></td>
                        <td>${data.realName}</td>
                    </tr>
                </c:forEach>
            </table>
            <div align="center">
                <c:if test="${pageSupport.currentPageNo>1}">
                    <a href="javascript:page_nav(1);">首页</a>|
                    <a href="javascript:page_nav(${pageSupport.currentPageNo-1});">&lt;&lt;上一页</a>|
                </c:if>
                <c:if test="${pageSupport.currentPageNo<=1}">
                    首页|&lt;&lt;上一页|
                </c:if>
                <c:if test="${pageSupport.currentPageNo<pageSupport.totalPageCount}">
                    <a href="javascript:page_nav(${pageSupport.currentPageNo+1});">下一页&gt;&gt;</a>|
                    <a href="javascript:page_nav(${pageSupport.totalPageCount});">尾页</a>
                </c:if>
                <c:if test="${pageSupport.currentPageNo>=pageSupport.totalPageCount}">
                    下一页&gt;&gt;|尾页
                </c:if>
                第
                ${pageSupport.currentPageNo}页/共${pageSupport.totalPageCount}页&nbsp;(共${pageSupport.totalRecordCount }条)
            </div>
        </div>

    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    function page_nav(page) {
        var frm = document.forms[0];
        frm.currentPage.value = page;
        frm.submit();
    }
</script>

</body>
</html>
