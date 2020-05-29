<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改IC卡信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        $("#updateCard").click(function () {
            var id = ${card.id};
            var ICUserName = $("#ICUserName").val();
            var ICIntegral = $("#ICIntegral").val();
            var phone = $("#phone").val();
            var userAddress = $("#userAddress").val();
            var param = {};
            param.id=id;
            param.ICUserName = ICUserName;
            param.ICIntegral = ICIntegral;
            param.phone = phone;
            param.userAddress = userAddress;
            $.ajax({
                url:"updateCards",
                type:"post",
                data:param,
                dataType:"json",
                success:function (result) {
                    alert("修改成功！");
                    location.href="cardlist1.jsp";
                }
            });
        });
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改IC卡信息</legend>
</fieldset>
<div class="layui-form " >
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>IC卡用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="putKG" lay-verify="required" placeholder="请输入IC卡用户名" autocomplete="off" class="layui-input" maxlength="11" required id="ICUserName" value=${card.ICUserName}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>积分余额</label>
        <div class="layui-input-inline">
            <input type="text" name="getIntegral" lay-verify="required" placeholder="请输入积分余额" autocomplete="off" class="layui-input" required id="ICIntegral" value=${card.ICIntegral}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>IC卡用户电话</label>
        <div class="layui-input-inline">
            <input type="text" name="putAddress" lay-verify="required" placeholder="请输入IC卡用户电话" autocomplete="off" class="layui-input"  required id="phone" value=${card.phone}>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>ic卡用户住址</label>
        <div class="layui-input-inline">
            <input type="text" name="userId" lay-verify="required" placeholder="请输入ic卡用户住址" autocomplete="off" class="layui-input" id="userAddress" value=${card.userAddress}>
        </div>
    </div>

    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" id="updateCard">提交</button>
    </div>
</div>

</body>
</html>
