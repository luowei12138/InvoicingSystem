<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2021/4/6
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
    <div style="background-color: #94ee94; width: 300px; height: 150px;">
        <h2>小型进销存系统</h2>
        <form action="/users/doLong" method="">
            <div>用户名<input name="userName"/></div>
            <div>密码：<input name="password"/></div>
            <div><input type="submit" value="登录"/></div>
            ${error}
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>
