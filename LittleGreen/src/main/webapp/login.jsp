<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录-小绿</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/login.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src="statics/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">
<div class="login layui-anim layui-anim-up">
    <div class="message">小绿-管理登录</div>
    <div id="darkbannerwrap"></div>
    <form method="post" class="layui-form" >
        <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" id="userName">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input" id="password">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit" id="loginBtn">
        <hr class="hr20" >
    </form>
</div>
<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form;
            //监听提交
            form.on('submit(login)', function(data){
                var userName = $("#userName").val();
                var password = $("#password").val();
                if (checkParam(userName,password)){
                    var param = {};
                    param.userName = userName;
                    param.password = password;
                    $.ajax({
                        url:"login",
                        type:"post",
                        data:param,
                        success:function (result) {
                            if (result.result==true && result.flag==4) {
                                alert("登陆成功，欢迎"+userName+"进入小绿管理后台！");
                                location.href = "index.jsp";
                            }else {
                                alert("登陆失败");
                            }
                        }
                    });
                }
                return false;
            });
        });
    })
    function checkParam(userName,password) {
        if (userName==""){
            alert("用户名不能为空!");
            return false;
        }
        if (password==""){
            alert("密码不能为空！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>