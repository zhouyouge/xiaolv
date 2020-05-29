<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加论坛记录</title>
    <link rel="stylesheet" href="statics/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/addForum.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加论坛记录:</legend>
</fieldset>
<%--<form class='layui-form' >--%>

<div class="layui-form-item">
    <label class="layui-form-label"  ><span style="color: red;">* </span>主题:</label>
    <div class="layui-input-inline">
        <input type="text" name="forumName" id="forumName" lay-verify="required" placeholder="请输入主题" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label" ><span style="color: red;">* </span>发布内容:</label>
    <div class="layui-input-inline">
        <input type="text" name="forumContent" id="forumContent" lay-verify="required" placeholder="请输入发布内容" autocomplete="off" class="layui-input" required>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label" ><span style="color: red;">* </span>上传者ID:</label>
    <div class="layui-input-inline">
        <input type="text" name="uploader" id="uploader" lay-verify="required" placeholder="请输入上传者ID" autocomplete="off" class="layui-input" maxlength="11" required>
    </div>
</div>

<div class="layui-form-item" style="margin-left: 110px;">
    <button class="layui-btn" lay-submit="" onclick="addFors()">提交</button>
    <button type="reset" class="layui-btn">重置</button>
</div>
</body>
</html>