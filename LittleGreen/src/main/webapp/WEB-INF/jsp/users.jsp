<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <script>
        function addUsers() {
            $.ajax({
                url:"addUsers",
                type:"get",
                success:function (result) {
                    $("#commment").html(result);

                }
            });
        }
       function updateUser(id) {
            $.ajax({
                url:"updateUser/"+id,
                type:"get",
                success:function (result) {
                    $("#commment").html(result);

                }
            });
        }
        function deleteUser(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"deleteUser",
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
    </script>
    <title>用户信息</title>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script src="statics/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="statics/js/xadmin.js"></script>
</head>
<body id="mianban">
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
                <div class="layui-card-header">
                    <%--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>--%>
                    <a class="layui-btn" href="javascript:addUsers()"><i class="layui-icon"></i>添加用户信息</a>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <tr>
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
                            <th>操作</th>
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
                                    <td><a href="javascript:updateUser(${userList.id})" class="layui-btn" style="background: #1E9FFF"><i class="layui-icon"></i>修改</a>
                                        <a href="javascript:deleteUser(${userList.id})" class="layui-btn" style="background: red; color: white">
                                            <i class="layui-icon"></i>删除</a>
                                    </td>
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
</html>

