<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改区域信息</title>
    <link rel="stylesheet" href="statics/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        function updateArea() {
            var id = ${area.id};
            var areaName = $("#areaName").val();
            var cabinetId = $("#cabinetId").val();
            var param = {};
            param.id = id;
            param.areaName = areaName;
            param.cabinetId = cabinetId;
            $.ajax({
                url:"updateArea",
                type:"post",
                data:param,
                dataType:"json",
                success:function (result) {
                    alert("修改成功");
                    queryList("");
                }
            });
        }
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改区域信息</legend>
</fieldset>

<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>区域名</label>
    <div class="layui-input-inline">
        <input type="text" name="address" lay-verify="required" value="${area.areaName}" autocomplete="off" class="layui-input" required id="areaName">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label"><span style="color: red;">* </span>回收柜ID</label>
    <div class="layui-input-inline">
        <input type="text" name="state" lay-verify="required" value="${area.cabinetId}" autocomplete="off" class="layui-input" maxlength="11" required id="cabinetId">
    </div>
</div>

<div class="layui-form-item" style="margin-left: 110px;">
    <button class="layui-btn" lay-submit="" lay-filter="demo2" onclick="updateArea()">提交</button>
</div>

</body>
</html>
