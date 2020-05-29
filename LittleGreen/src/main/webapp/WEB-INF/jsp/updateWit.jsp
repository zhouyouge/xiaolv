<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改提现记录</title>
    <link rel="stylesheet" href="statics/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            $("#updateWits2").click(function () {
                var id=${wit.id};
                var withdrawUser=$("#withdrawUser").val();
                var money=$("#money").val();
                var withdrawIntegral=$("#Integral").val();
                var param={};
                param.id=id;
                param.withdrawUser=withdrawUser;
                param.money=money;
                param.withdrawIntegral=withdrawIntegral;
                $.ajax({
                    url:"updeteWits",
                    type:"post",
                    data:param,
                    dataType:"json",
                    success:function (result) {
                        if (result!=""){
                            if (result.result==false){
                                if (result.flag==7){
                                    location.href="index.jsp";
                                }
                                if (result.flag==0){
                                    alert(result.data);
                                }
                                if (result.flag==1){
                                    alert(result.data);
                                }
                                if (result.flag==2){
                                    alert(result.data);
                                }
                                if (result.flag==3){
                                    alert(result.data);
                                }
                                if (result.flag==4){
                                    alert(result.data);
                                }
                            }else {
                                if (result.flag==7){
                                    alert(result.data);
                                    //请求销售记录信息列表

                                }
                            }
                        }
                        queryList("");
                    }
                });
            }) ;
        });

    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改提现记录</legend>
</fieldset>
<%--<form class='layui-form' >--%>
<div class="layui-form-item">
    <label class="layui-form-label"  ><span style="color: red;">* </span>提现人编号:</label>
    <div class="layui-input-inline">
        <input type="text" name="id"
               id="id" lay-verify="required" value="${wit.id}" disabled
               placeholder="请输入提现人ID" autocomplete="off" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label"  ><span style="color: red;">* </span>提现人姓名ID:</label>
    <div class="layui-input-inline">
        <input type="text" name="withdrawUser"
               id="withdrawUser" lay-verify="required" value="${wit.withdrawUser}" disabled
               placeholder="请输入提现人ID" autocomplete="off" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label" ><span style="color: red;">* </span>提现金额:</label>
    <div class="layui-input-inline">
        <input type="text" name="money" id="money" lay-verify="required" value="${wit.money}" placeholder="请输入提现金额" autocomplete="off" class="layui-input" required>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label" ><span style="color: red;">* </span>提现积分:</label>
    <div class="layui-input-inline">
        <input type="text" name="Integral" id="Integral" lay-verify="required" value="${wit.withdrawIntegral}" placeholder="请输入提现积分" autocomplete="off" class="layui-input" maxlength="11" required>
    </div>
</div>
<div class="layui-form-item" style="margin-left: 110px;">
    <button class="layui-btn" lay-submit="" id="updateWits2">提交</button>
    <button type="reset" class="layui-btn">重置</button>
</div>
</body>
</html>
