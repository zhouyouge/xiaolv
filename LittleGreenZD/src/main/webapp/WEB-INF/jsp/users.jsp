<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src="statics/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="statics/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body id="mianban">
<div class="x-nav">
          <%--<span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>--%>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <%--<div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>--%>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <tr style="background: whitesmoke;">
                            <th>用户编号</th>
                            <th>用户类型</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>真实姓名</th>
                            <th>地址</th>
                            <th>电话号</th>
                            <th>积分</th>
                            <th>账户余额</th>
                            <th>创建日期</th>
                            <th>修改日期</th>
                        </tr>
                        <l:if test="${not empty userList}">
                            <l:forEach items="${userList.userList}" var="userList">
                                <tr>
                                    <td>${userList.id}</td>
                                    <td>${userList.roleName}</td>
                                    <td>${userList.userName}</td>
                                    <td>${userList.password}</td>
                                    <td>${userList.realName}</td>
                                    <td>${userList.address}</td>
                                    <td>${userList.userPhone}</td>
                                    <td>${userList.integral}</td>
                                    <td>${userList.account}</td>
                                    <td><fmt:formatDate value="${userList.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                    <td><fmt:formatDate value="${userList.miTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                </tr>
                            </l:forEach>
                        </l:if>
                    </table>
                </div>
                <div class="layui-card-body ">
                    <div class="page">
                        <a href="javascript:firstPage()">首页</a>
                        <a href="javascript:prePage()">上一页</a>
                        <a href="javascript:nextPage()">下一页</a>
                        <a href="javascript:endPage()">末页</a>
                        <span>
                        当前: 第<span class="curPage">${userList.curPage}</span>页/共
                            <span class="totalPageCount">${userList.totalPageCount}</span>页
                        (<span class="totalCount">${userList.totalCount}</span>个记录)
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){

            if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

            }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }



    function delAll (argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</html>

