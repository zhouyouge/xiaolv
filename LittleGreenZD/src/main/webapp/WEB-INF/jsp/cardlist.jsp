<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="statics/css/font.css">
    <link rel="stylesheet" href="statics/css/xadmin.css">
    <script type="text/javascript" src="/statics/js/jquery-1.12.4.js"></script>
    <script>
        function delCard(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"delCard",
                    type:"get",
                    data:"id="+id,
                    dataType:"json",
                    success:function (result) {
                        if(result!=""){
                            alert("删除成功！");
                            location.href="cardlist1.jsp";
                        }
                    }
                });
            }
        }
    </script>
</head>
<div class="layui-card-header">
    <%-- <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>--%>
    <a class="layui-btn" href="/addCard"><i class="layui-icon"></i>添加IC卡</a>
</div>
<div class="layui-card-body layui-table-body layui-table-main">
    <div>
        <table class="layui-table layui-form">
            <tr style="background: whitesmoke;">
                <th>编号</th>
                <th>IC卡用户名</th>
                <th>积分余额</th>
                <th>手机号</th>
                <th>IC卡用户住址</th>
                <th>办理时间</th>
                <th>操作</th></tr>
            </tr>
            <c:if test="${not empty cardList.cardList}">
                <c:forEach items="${cardList.cardList}" var="card">
                    <tr>
                        <td>${card.id}</td>
                        <td>${card.ICUserName}</td>
                        <td>${card.ICIntegral}</td>
                        <td>${card.phone}</td>
                        <td>${card.userAddress}</td>
                        <td><fmt:formatDate value="${card.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>
                            <a href="/addCard" class="layui-btn"
                               style="background: forestgreen;color: white;background-size: 20px"><i class="layui-icon"></i>添加</a>
                            <a href="javascript:updateCard(${card.id})" class="layui-btn" style="background: #1E9FFF"><i class="layui-icon"></i>修改</a>
                            <a href="javascript:delCard(${card.id})" class="layui-btn" style="background: red; color: white"><i class="layui-icon"></i>删除</a>
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
                    当前页：<span class="curPage">${cardList.data.curPage}</span>
                    /共<span class="totalPageCount">${cardList.data.totalPageCount}</span>页
                    (<span class="totalCount">${cardList.data.totalCount}</span>个记录)
                </span>
                </div>
            </div>
        </div>
    </div>
</div>
