<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改投放记录</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
  <script>

            $("#updatePutin").click(function () {
            var id = ${putin.id};
            var putKG = $("#putKG").val();
            var getIntegral = $("#getIntegral").val();
            var putAddress = $("#putAddress").val();
            var userId = $("#userId").val();
                var param = {};
                param.id=id;
                param.putKG = putKG;
                param.getIntegral = getIntegral;
                param.putAddress = putAddress;
                param.userId=userId;
                $.ajax({
                    url:"updatePutins",
                    type:"post",
                    data:param,
                    dataType:"json",
                    success:function (result) {
                        alert("修改成功！");
                        location.href="PutinList1.jsp";
                    }
                });
            });
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改投放记录</legend>
</fieldset>
<%--<div>
    <c:if test="${not empty putin}">
        <input  type="hidden" value="${putin.id}"/>${putin.id}<br/>
    </c:if>
</div>--%>
<div class="layui-form " >
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>投放重量</label>
        <div class="layui-input-inline">
            <input type="text" name="putKG" lay-verify="required" placeholder="请输入投放重量" autocomplete="off" class="layui-input" maxlength="11" required id="putKG" value=${putin.putKG}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>获取积分</label>
        <div class="layui-input-inline">
            <input type="text" name="getIntegral" lay-verify="required" placeholder="请输入获取积分" autocomplete="off" class="layui-input" required id="getIntegral" value=${putin.getIntegral}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>投放地址</label>
        <div class="layui-input-inline">
            <input type="text" name="putAddress" lay-verify="required" placeholder="请输入投放地址" autocomplete="off" class="layui-input"  required id="putAddress" value=${putin.putAddress}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>用户ID</label>
        <div class="layui-input-inline">
            <input type="text" name="userId" lay-verify="required"
                   placeholder="请输入用户ID" autocomplete="off" class="layui-input" id="userId" value=${putin.userId}>
        </div>
    </div>

    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" id="updatePutin">提交</button>
    </div>
</div>

</body>
</html>
