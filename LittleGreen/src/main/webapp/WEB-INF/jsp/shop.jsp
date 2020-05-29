<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>商城信息</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src=statics/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="statics/js/xadmin.js"></script>
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <%--[if lt IE 9]--%>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <%--[endif]--%>
</head>
<body>
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <%--<form class="layui-form layui-col-space5">
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
                    </form>--%>
                </div>
                <div class="layui-card-header">
                    <%--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>--%>
                    <a href="/addS" class="layui-btn"><i class="layui-icon"></i>添加商城信息</a>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <tr style="background: whitesmoke;">
                            <th>商品编号</th>
                            <th>商品名称</th>
                            <th></th>
                            <th>商品价格</th>
                            <th>添加时间</th>
                            <th>修改时间</th>
                            <th>操作</th></tr>
                        </tr>
                        <div class="xiu">
                            <c:if test="${not empty Response.shopList}">
                                <c:forEach items="${Response.shopList}" var="shop">
                                    <tr>
                                        <td>${shop.id}</td>
                                        <td>${shop.shopName}</td>
                                        <td>${shop.shopPrice}</td>
                                        <td><fmt:formatDate value="${shop.createTime}" pattern="yyyy-MM-dd hh-mm-ss" /></td>
                                        <td><fmt:formatDate value="${shop.miTime}" pattern="yyyy-MM-dd hh-mm-ss" /></td>
                                        <td>
                                            <a onclick="updateShop(${shop.id})" class="layui-btn" style="background: #1E9FFF"><i class="layui-icon"></i>修改</a>
                                            <a href="javascript:deleteShop(${shop.id})" class="layui-btn" style="background: red; color: white">
                                                <i class="layui-icon"></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </div>
                    </table>
                </div>
                <div class="layui-card-body ">
                    <div class="page">
                        <div>
                            <a class="prev" href="#" onclick="prePage()">上一页</a>
                            <a class="num" href="#"  onclick="firstPage()">首页</a>
                            <a class="num"  href="#" onclick="endPage()">末页</a>
                            <a class="next" href="#"  onclick="nextPage()">下一页</a>
                            <span>
                                当前页：<span class="curPage">${Response.data.curPage}</span>
                                /共<span class="totalPageCount">${Response.data.totalPageCount}</span>页
                                (<span class="totalCount">${Response.data.totalCount}</span>个记录)
                            </span>
                        </div>
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
</html>