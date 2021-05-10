<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2021/4/6
  Time: 11:16
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
        <h1>添加销售</h1>
        <form action="/" method="post" onsubmit="return onSubmit()">
            <table>
                <tr>
                    <td><label for="productId">商品名称：</label></td>
                    <span>${error }</span>
                    <td>
                        <select name="productId" id="productId">
                            <option value="-1">=== 请选择商品 ===</option>
                            <c:forEach var="list" items="${productList}">
                                <option value="${list.id}">${list.productName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="price">销售单价：</label></td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td><label for="quantity">销售数量：</label></td>
                    <td><input type="text" name="quantity" id="quantity"></td>
                </tr>
                <tr>
                    <th colspan="2"><input type="submit" value="保存"></th>
                </tr>
            </table>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
        function onSubmit() {
            var productId = $("select[name='productId']").val();
            var price = $("input[name='price']").val();
            var quantity = $("input[name='quantity']").val();
            alert(productId);
            if (productId === -1) {
                alert("请选择商品")
                return false
            }
            if (!/^\d*.?\d*$/.test(price)) {
                alert("销售单价必须为数字，可有浮点数")
                return false
            }
            if (!/^\d+$/.test(quantity)) {
                alert("销售数量必须是数字!");
                return false
            }

            var sale = {
                'productId' : $("select[name='productId']").val(),
                'price' :  $("input[name='price']").val(),
                'quantity' : $("input[name='quantity']").val()
            }

            $.ajax({
                url: "/users/doAddSale",
                type: "GET",
                dataType:"json",
               //contentType:"application/json",
                data:sale,
                success: function (result){
                    if(result.code == 200){
                        alert("sale添加成功！");
                        location= "/users/toSaleList";
                    }else {
                        alert('失败！');
                    }
                }
            })

            return false;
        }
    </script>

</body>
</html>
