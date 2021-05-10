<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2021/4/6
  Time: 9:23
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

<div align="center">
    <h3>
        <strong>欢迎你：${userSession.realName }</strong>
        <a href="/users/logout" onclick="if(confirm('确定退出系统?')==false)return false;">退出系统</a>
    </h3>
    <div>
        <div>
            <a href="/users/toAddSale" target="page">销售</a>
            <a href="/users/toSaleList" target="page">销售信息查询</a>
            <a href="/product/queryQuantity" target="page">库存查询</a>
        </div>

        <div>
            <iframe name="page" width="800px" height="800px"  src="/users/hello"></iframe>
        </div>


    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>
