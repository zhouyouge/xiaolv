<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加区域信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        function addArea() {
            var id = $("#aid").val();
            var areaName = $("#areaName").val();
            var cabinetId = $("#cabinetId").val();
            var param = {};
            param.id = id;
            param.areaName = areaName;
            param.cabinetId = cabinetId;
            $.ajax({
                url:"addArea",
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
    <legend>添加区域信息</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>ID</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" maxlength="11" required id="aid">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>区域名</label>
    <div class="layui-input-inline">
        <input type="text" name="address" lay-verify="required" placeholder="请输入区域名" autocomplete="off" class="layui-input" required id="areaName">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>回收柜ID</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" placeholder="回收柜ID" autocomplete="off" class="layui-input" maxlength="11" required id="cabinetId">
    </div>
</div>

<div class="layui-form-item" style="margin-left: 110px;">
    <button class="layui-btn" lay-submit="" lay-filter="demo2" onclick="addArea()">提交</button>
</div>

</body>
</html>
