<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>

        $("#updateConversion").click(function () {
            var id = ${conversion.id};
            var conversionUser = $("#conversionUser").val();
            var conversionId = $("#conversionId").val();
            var conversionIntegral = $("#conversionIntegral").val();
            var param = {};
            param.id=id;
            param.conversionUser = conversionUser;
            param.conversionId = conversionId;
            param.conversionIntegral = conversionIntegral;
            $.ajax({
                url:"updateConversions",
                type:"post",
                data:param,
                dataType:"json",
                success:function (result) {
                    alert("修改成功！");
                    location.href="ConversionList1.jsp";
                }
            });
        });
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改兑换记录信息</legend>
</fieldset>
<%--<div>
    <c:if test="${not empty putin}">
        <input  type="hidden" value="${putin.id}"/>${putin.id}<br/>
    </c:if>
</div>--%>
<div class="layui-form " >
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>兑换人姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="putUser" lay-verify="required" placeholder="请输入兑换人姓名" autocomplete="off" class="layui-input" required id="conversionUser"  value=${conversion.conversionUser}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>兑换商品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="putKG" lay-verify="required" placeholder="请输入兑换商品名称" autocomplete="off" class="layui-input" maxlength="11" required id="conversionId" value=${conversion.conversionId}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>花费积分</label>
        <div class="layui-input-inline">
            <input type="text" name="getIntegral" lay-verify="required" placeholder="请输入花费积分" autocomplete="off" class="layui-input" required id="conversionIntegral" value=${conversion.conversionIntegral}>
        </div>
    </div>
    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" id="updateConversion">提交</button>
    </div>
</div>

</body>
</html>
