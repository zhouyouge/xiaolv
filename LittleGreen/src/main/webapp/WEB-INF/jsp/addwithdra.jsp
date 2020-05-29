<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="statics/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/addWit.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加提现记录</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加提现记录:</legend>
</fieldset>
<%--<form class='layui-form' >--%>

    <div class="layui-form-item">
        <label class="layui-form-label"  ><span style="color: red;">* </span>提现人ID:</label>
        <div class="layui-input-inline">
            <input type="text" name="withdrawUser" id="withdrawUser" lay-verify="required" placeholder="请输入提现人ID" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>提现金额:</label>
        <div class="layui-input-inline">
            <input type="text" name="money" id="money" lay-verify="required" placeholder="请输入提现金额" autocomplete="off" class="layui-input" required>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>提现积分:</label>
        <div class="layui-input-inline">
            <input type="text" name="Integral" id="Integral" lay-verify="required" placeholder="请输入提现积分" autocomplete="off" class="layui-input" maxlength="11" required>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"  ><span style="color: red;">* </span>投放人ID:</label>
        <div class="layui-input-inline">
            <input type="text" name="putinId" id="putinId" lay-verify="required" placeholder="请输入投放人ID" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" onclick="addWits()">提交</button>
        <button type="reset" class="layui-btn">重置</button>
    </div>
</body>
</html>
