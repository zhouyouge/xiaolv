<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src="statics/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="statics/js/xadmin.js"></script>
    <%--[if lt IE 9]--%>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <%--[endif]--%>
    <script>
        function addAreas() {
            $.ajax({
                url:"addArea",
                type:"get",
                success:function (result) {
                    $("#areaCommment").html(result);
                }
            });
        }
        function deleteArea(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"deleteArea",
                    type:"get",
                    data:"id="+id,
                    dataType:"json",
                    success:function (result) {
                        alert("删除成功");
                        queryList("");
                    }
                });
            }
        }
        function updateArea(id) {
            $.ajax({
                url:"updateArea/"+id,
                type:"get",
                success:function (result) {
                    $("#areaCommment").html(result);

                }
            });
        }
    </script>
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
                            <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>--%>
                </div>
                <div class="layui-card-header">
                    <%--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>--%>
                    <a class="layui-btn" href="javascript:addAreas()"><i class="layui-icon"></i>添加区域信息</a>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <tr>
                            <th>ID</th>
                            <th>地区名</th>
                            <th>垃圾柜地址</th>
                            <th>创建日期</th>
                            <th>状态</th>
                            <th>修改日期</th>
                            <th>操作</th>
                        <c:if test="${not empty area}">
                            <c:forEach items="${area.areaList}" var="are">
                                <tr>
                                    <td>${are.id}</td>
                                    <td>${are.areaName}</td>
                                    <td>${are.cabinetAddress}</td>
                                    <td><fmt:formatDate value="${are.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                                    <td>${are.state}</td>
                                    <td><fmt:formatDate value="${are.miTime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                                    <td>
                                        <a href="javascript:updateArea(${are.id})" class="layui-btn" style="background: #1E9FFF"><i class="layui-icon"></i>修改</a>
                                        <a href="javascript:deleteArea(${are.id})" class="layui-btn" style="background: red; color: white">
                                            <i class="layui-icon"></i>删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
                <div class="layui-card-body ">
                    <div class="page">
                        <a class="prev" href="javascript:;" onclick="firstPage()">首页</a>
                        <a class="num" href="javascript:;" onclick="prePage()">上一页</a>
                        <a class="num" href="javascript:;" onclick="nextPage()">下一页</a>
                        <a class="next" href="javascript:;" onclick="endPage()">末页</a>
                        <span>
                        当前: 第<span class="curPage">${area.curPage}</span>页/共
                            <span class="totalPageCount">${area.totalPageCount}</span>页
                        (<span class="totalCount">${area.totalCount}</span>个记录)
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
