<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src="statics/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="statics/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        $(function  () {
            var yemian=$("#yemian").val();
            if(yemian!=null){
                if(yemian=="updatePutin1.jsp"){
                    var id=<%=request.getParameter("id")%>;
                    $("#zhuomian").attr('src',yemian);
                    <%
                    session.setAttribute("id1",request.getParameter("id"));
                    %>
                }
            }
            if(yemian!=null){
                if(yemian=="updateCard1.jsp"){
                    var id=<%=request.getParameter("id")%>;
                    $("#zhuomian").attr('src',yemian);
                    <%
                    session.setAttribute("id2",request.getParameter("id"));
                    %>
                }
            }
            if(yemian!=null){
                if(yemian=="updateConversion1.jsp"){
                    var id=<%=request.getParameter("id")%>;
                    $("#zhuomian").attr('src',yemian);
                    <%
                    session.setAttribute("id3",request.getParameter("id"));
                    %>
                }
            }
            $("#loginOut").click(function () {
                if (confirm("您确定要离开我吗？")){
                    $.ajax({
                        url:"loginOut",
                        type:"get",
                        dataType:"json",
                        success:function (result) {
                            if (result.result==true && result.flag==1){
                                alert("退出成功！");
                                location.href="index.jsp";
                            }else {
                                alert("退出失败！");
                                location.href="main.jsp";
                            }
                        }
                    });
                }
            });
        });

        function ICka() {
            $("#zhuomian").attr('src', 'cardlist1.jsp');
        }
        function cabinet() {
            $("#zhuomian").attr('src', 'area.jsp');
        }
        function usersPage() {
            $("#zhuomian").attr('src','users1.jsp');
        }
        function ditu() {
            alert("ditu");
            $("#zhuomian").attr('src','ditu.jsp');
        }
    </script>
</head>
<body class="index">

<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="index.jsp">小绿区域管理系统</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">管理员：${user.userName}</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <%--<dd>
                    <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>--%>
                <%--<dd>
                    <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>--%>
                <dd>
                    <a href="#" id="loginOut" style="font-size: 13px">退出</a></dd>
            </dl>
        </li>
        <%--<li class="layui-nav-item to-index">
            <a href="/">前台首页</a></li>--%>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="用户管理">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="usersPage()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite >用户信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="回收柜管理">&#xe723;</i>
                    <cite>回收柜管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="cabinet()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>回收柜信息</cite></a>
                    </li>
                    <li>
                        <a onclick="ditu()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>回收柜区域信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="IC卡管理">&#xe75a;</i>
                    <cite>IC卡管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <%--<a onclick="xadmin.add_tab('IC卡用户信息','')">--%>
                        <a onclick="ICka()">
                            <i class="iconfont">&#xe6a7;</i><cite >IC卡信息表</cite>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false" style="background: white;background-size: 100%">
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='Shouye.jsp' frameborder="0" scrolling="yes" class="x-iframe" id="zhuomian"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<div id ="hidden">
    <input  id="yemian" value=<%=request.getParameter("name")%>/>
</div>
<!-- 右侧主体结束 -->
</body>
</html>