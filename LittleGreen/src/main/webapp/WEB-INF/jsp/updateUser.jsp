<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改用户信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
           $("#updateUsers").click(function () {
               var id = $("#userId").val();
               var password = $("#password").val();
               var roleId = $("#roleId").val();
               var realName = $("#realName").val();
               var address = $("#address").val();
               var userPhone = $("#userPhone").val();
               var param = {};
               param.id = id;
               param.password=password;
               param.roleId=roleId;
               param.realName=realName;
               param.address=address;
               param.userPhone = userPhone;
               $.ajax({
                   url:"update",
                   type:"post",
                   data:param,
                   dataType:"json",
                   success:function (result) {
                       alert("修改成功");
                       queryList("");

                   }
               });
           });
        });
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改用户信息</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>用户id</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" value="${users.id}" autocomplete="off" class="layui-input" maxlength="11" required id="userId">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>密码</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" value="${users.password}" autocomplete="off" class="layui-input" maxlength="11" required id="password">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>角色</label>
    <div class="layui-input-inline">
        <input type="text" name="addTime" lay-verify="required" value="${users.roleId}" autocomplete="off" class="layui-input" id="roleId">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>真实姓名</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" value="${users.realName}" autocomplete="off" class="layui-input" maxlength="11" required id="realName">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>地址</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" value="${users.address}" autocomplete="off" class="layui-input" maxlength="11" required id="address">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>电话</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" value="${users.userPhone}" autocomplete="off" class="layui-input" maxlength="11" required id="userPhone">
    </div>
</div>
<div class="layui-form-item" style="margin-left: 110px;">
    <button class="layui-btn" lay-submit="" lay-filter="demo2" id="updateUsers" >提交</button>
</div>
</body>
</html>

