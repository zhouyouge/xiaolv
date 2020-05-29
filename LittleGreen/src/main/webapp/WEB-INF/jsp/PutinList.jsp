<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>投放记录信息</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src=statics/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="statics/js/xadmin.js"></script>
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        function delPutin(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"delPutin",
                    type:"get",
                    data:"id="+id,
                    dataType:"json",
                    success:function (result) {
                        if(result!=""){
                            alert("删除成功！");
                            location.href="PutinList1.jsp";
                        }
                    }
                });
            }
        }
    </script>
</head>
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
                <%--<div class="layui-card-header">--%>
                    <%--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>--%>
                    <a href="/addPutin" class="layui-btn"><i class="layui-icon"></i>添加投放记录</a>
                <%--</div>--%>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <div>
                        <table class="layui-table layui-form">
                            <tr style="background: whitesmoke;">
                                <th>编号</th>
                                <th>投放人</th>
                                <th>投放重量</th>
                                <th>获取积分</th>
                                <th>投放时间</th>
                                <th>投放地址</th>
                                <th>操作</th></tr>
                            </tr>
                            <c:if test="${not empty putList.putinList}">
                                <c:forEach items="${putList.putinList}" var="putin">
                                    <tr>
                                        <td>${putin.id}</td>
                                        <td>${putin.userName}</td>
                                        <td>${putin.putKG}</td>
                                        <td>${putin.getIntegral}</td>
                                        <td><fmt:formatDate value="${putin.putTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                        <td>${putin.areaName}</td>
                                        <td>
                                            <a href="javascript:updatePutin(${putin.id})"  class="layui-btn" style="background: #1E9FFF"><i class="layui-icon"></i>修改</a>
                                            <a href="javascript:delPutin(${putin.id})" class="layui-btn" style="background: red; color: white"><i class="layui-icon"></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </table>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                    <a class="prev" href="#" onclick="prePage()">上一页</a>
                                    <a class="num" href="#"  onclick="firstPage()">首页</a>
                                    <a class="num"  href="#" onclick="endPage()">末页</a>
                                    <a class="next" href="#"  onclick="nextPage()">下一页</a>
                                    <span>
                    当前页：<span class="curPage">${putList.data.curPage}</span>
                    /共<span class="totalPageCount">${putList.data.totalPageCount}</span>页
                    (<span class="totalCount">${putList.data.totalCount}</span>个记录)
                </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



