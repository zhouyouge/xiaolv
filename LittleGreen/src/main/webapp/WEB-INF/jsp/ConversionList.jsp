<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script type="text/javascript" src="/statics/js/jquery-1.12.4.js"></script>
    <script>
        function delConversion(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"delConversion",
                    type:"get",
                    data:"id="+id,
                    dataType:"json",
                    success:function (result) {
                        if(result!=""){
                            alert("删除成功！");
                            location.href="ConversionList1.jsp";
                        }
                    }
                });
            }
        }
    </script>
</head>
<div class="layui-card-body layui-table-body layui-table-main">
    <div>
        <table class="layui-table layui-form">
            <tr style="background: whitesmoke;">
                <th>编号</th>
                <th>兑换人</th>
                <th>商品名称</th>
                <th>花费积分</th>
                <th>兑换时间</th>
                <th>操作</th></tr>
            </tr>
            <c:if test="${not empty conList.conversionList}">
                <c:forEach items="${conList.conversionList}" var="con">
                    <tr>
                        <td>${con.id}</td>
                        <td>${con.userName}</td>
                        <td>${con.shopName}</td>
                        <td>${con.conversionIntegral}</td>
                        <td><fmt:formatDate value="${con.conversionTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>
                            <%--<a href="/addPutin" onclick="addPutin()"
                               style="background: forestgreen;color: white;background-size: 20px">添加</a>&nbsp;&nbsp;--%>
                            <a href="javascript:updateConversion(${con.id})" class="layui-btn" style="background: #1E9FFF"><i class="layui-icon"></i>修改</a>
                            <a href="javascript:delConversion(${con.id})"class="layui-btn" style="background: red; color: white"><i class="layui-icon"></i>删除</a>
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
                    当前页：<span class="curPage">${conList.data.curPage}</span>
                    /共<span class="totalPageCount">${conList.data.totalPageCount}</span>页
                    (<span class="totalCount">${conList.data.totalCount}</span>个记录)
                </span>
                </div>
            </div>
        </div>
    </div>
</div>


