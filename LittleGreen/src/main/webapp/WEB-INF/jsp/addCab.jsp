<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/addCab.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加回收柜信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加回收柜信息</legend>
</fieldset>
<%--<form class="layui-form " >--%>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>回收柜编号</label>
        <div class="layui-input-inline">
            <input type="text" name="id" lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input" id="ids">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>回收柜地址</label>
        <div class="layui-input-inline">
            <input type="text" name="address" lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input" required  id="address">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red;">* </span>回收柜状态</label>
        <div class="layui-input-inline">
            <input type="text" name="state" lay-verify="required" placeholder="请输入回收柜状态" autocomplete="off" class="layui-input" maxlength="11" required  id="state">
        </div>
    </div>

    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" onclick="addCab()">提交</button>
        <button type="reset" class="layui-btn">重置</button>
     </div>
<%--</form>--%>

</body>
</html>
