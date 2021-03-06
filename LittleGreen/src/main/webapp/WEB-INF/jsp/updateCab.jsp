<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改回收柜信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改回收柜信息</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>回收柜编号</label>
    <div class="layui-input-inline">
        <input type="text" name="id" id="ids" lay-verify="required" value="${cabinet.id}" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>回收柜地址</label>
    <div class="layui-input-inline">
        <input type="text" name="address" id="address" lay-verify="required" value="${cabinet.cabinetAddress}" autocomplete="off" class="layui-input" required>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>回收柜状态</label>
    <div class="layui-input-inline">
        <input type="text" name="state" id="state" lay-verify="required" value="${cabinet.state}" autocomplete="off" class="layui-input" maxlength="11" required>
    </div>
</div>
<div class="layui-form-item" style="margin-left: 110px;">
    <button class="layui-btn" lay-submit="" lay-filter="demo2" onclick="updateCab1()">提交</button>
    <button type="reset" class="layui-btn">重置</button>
</div>
</body>
</html>
