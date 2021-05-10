<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2021/4/6
  Time: 16:26
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
    <div style="float: left"><strong>查看库存</strong></div>
    <div>
        <form action="/product/queryQuantity" method="post" onsubmit="return onSubmit()">
            <label for="proName">商品名称：</label>
            <select name="id" id="proName">
                <option value="-1">==== 请选择商品 ====</option>
                <c:forEach var="data" items="${list}">
                    <option ${id == data.id ? "selected" : ""} value="${data.id}">${data.productName}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form>
    </div>
</div>

<c:if test="${quantity != null}">
    <h1>该商品的库存数量是：${quantity}</h1>
</c:if>

<script>
    'use strict'
    function onSubmit() {
        if(Number(document.forms[0].id.value) === -1) {
            alert("请选择商品")
            return false
        }
    }
</script>
</body>
</html>
