<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="statics/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="statics/js/xadmin.js"></script>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>小绿管理后台</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">

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
                                location.href="login.jsp";
                            }else {
                                alert("退出失败！");
                                location.href="index.jsp";
                            }
                        }
                    });
                }
            });
        });
        function addToufang() {
            $("#zhuomian").attr('src', 'PutinList1.jsp');
        }
        function ditu() {
            $("#zhuomian").attr('src', 'ditu.jsp');
        }
        function ICka() {
            $("#zhuomian").attr('src', 'cardlist1.jsp');
        }
        function shop() {
            $("#zhuomian").attr('src', 'shop1.jsp');
        }
        function cabinet() {
            $("#zhuomian").attr('src', 'cabinet1.jsp');
        }
        function jifenDuihuan() {
            $("#zhuomian").attr('src', 'ConversionList1.jsp');
        }
        function areaPage() {
            $("#zhuomian").attr('src','areaPage1.jsp');
        }
        function usersPage() {
            $("#zhuomian").attr('src','users1.jsp');
        }
        function Withd() {
            $("#zhuomian").attr("src","withdraw.jsp");
        }
        function Forum() {
            $("#zhuomian").attr("src","Forum.jsp");
        }
        function TuCabinet() {
            $("#zhuomian").attr("src","Tucabinet1.jsp");
        }
        function Rubbish() {
            $("#zhuomian").attr("src","Rubbish1.jsp");
        }
    </script>
</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="statics/index.jsp">小绿—管理后台</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"></a>
            <%--<dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">
                        <i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>
                <dd>
                    <a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">
                        <i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>
                <dd>
                    <a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">
                        <i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>
                <dd>
                    <a onclick="xadmin.add_tab('在tab打开','member-list.html')">
                        <i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
                <dd>
                    <a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">
                        <i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>
            </dl>--%>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">超级管理员：${user.userName}</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd>
                    <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                <dd>
                    <a href="#" id="loginOut">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index">
            <a href="#">前台首页</a></li>
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
                            <cite>用户信息</cite></a>
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
                            <cite>回收柜分布图</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="区域管理">&#xe715;</i>
                    <cite>区域管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="areaPage()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>区域信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="商城管理">&#xe698;</i>
                    <cite>商城管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="shop()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>商城信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="系统统计">&#xe6ce;</i>
                    <cite>系统统计</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="TuCabinet()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>回收柜分布统计图</cite></a>
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
                        <a onclick="ICka()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>IC卡信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="投放记录管理">&#xe74a;</i>
                    <cite>投放记录管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="addToufang()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>投放记录信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="积分兑换管理">&#xe758;</i>
                    <cite>积分兑换管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="jifenDuihuan()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>积分兑换记录信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="提现记录管理">&#xe702;</i>
                    <cite>提现记录管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="Withd()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>提现记录查询</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="垃圾信息管理">&#xe806;</i>
                    <cite>垃圾信息管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="Rubbish()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>垃圾信息</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="论坛信息管理">&#xe6ba;</i>
                    <cite>论坛信息管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="Forum()">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>论坛信息查询</cite></a>
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
        <%--<ul class="layui-tab-title">
            <li class="home">
                <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd></dl>
        </div>--%>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src="Shouye.jsp" frameborder="0" scrolling="yes" class="x-iframe" id="zhuomian"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<div id ="hidden">
    <input  id="yemian" value=<%=request.getParameter("name")%>/>
</div>
</body>

</html>