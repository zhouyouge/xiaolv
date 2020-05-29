<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加用户信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">

    <script>
        $(function () {
            alert("dfsfdsds");
            addUser();
        });
        function addUser() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var roleId = $("#roleId").val();
            var realName = $("#realName").val();
            var address = $("#address").val();
            var userPhone = $("#userPhone").val();
            var param = {};
            param.userName =userName;
            param.password=password;
            param.roleId=roleId;
            param.realName=realName;
            param.address=address;
            param.userPhone = userPhone;
            $.ajax({
                url:"addUsers",
                type:"post",
                data:param,
                dataType:"json",
                success:function (result) {
                    alert("添加成功");
                    queryList("");
                }
            });

        }

    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加用户信息</legend>
</fieldset>
<%--<form class="layui-form " >--%>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="address" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" required id="userName">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>密码</label>
        <div class="layui-input-inline">
            <input type="text" name="state" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" maxlength="11" required id="password">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>角色</label>
        <div class="layui-input-inline">
            <input type="text" name="addTime" lay-verify="required" placeholder="请输入角色id" autocomplete="off" class="layui-input" id="roleId">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>真实姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="state" lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input" maxlength="11" required id="realName">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>地址</label>
        <div class="layui-input-inline">
            <input type="text" name="state" lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input" maxlength="11" required id="address">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>电话</label>
        <div class="layui-input-inline">
            <input type="text" name="state" lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input" maxlength="11" required id="userPhone">
        </div>
    </div>

    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" onclick="addUser()">提交</button>
    </div>
<%--</form>--%>

</body>
</html>
