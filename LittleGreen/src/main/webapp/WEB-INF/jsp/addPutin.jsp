<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/addPutin.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加投放记录信息</legend>
</fieldset>
<div class="layui-form " >
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>投放人姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="putUser" lay-verify="required" placeholder="请输入投放人姓名" autocomplete="off" class="layui-input" required id="putUser">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>投放重量</label>
        <div class="layui-input-inline">
            <input type="text" name="putKG" lay-verify="required" placeholder="请输入投放重量" autocomplete="off" class="layui-input" maxlength="11" required id="putKG">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>获取积分</label>
        <div class="layui-input-inline">
            <input type="text" name="getIntegral" lay-verify="required" placeholder="请输入获取积分" autocomplete="off" class="layui-input" required id="getIntegral">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>投放地址</label>
        <div class="layui-input-inline">
            <input type="text" name="putAddress" lay-verify="required" placeholder="请输入投放地址" autocomplete="off" class="layui-input"  required id="putAddress">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" ><span style="color: red;">* </span>用户ID</label>
        <div class="layui-input-inline">
            <input type="text" name="userId" lay-verify="required" placeholder="请输入用户ID" autocomplete="off" class="layui-input" id="userId">
        </div>
    </div>

    <div class="layui-form-item" style="margin-left: 110px;">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" onclick="addPutin()">提交</button>
    </div>
</div>

</body>
</html>
