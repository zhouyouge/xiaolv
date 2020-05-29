<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页</title>
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            queryList("");
        });
        function queryList(param) {
            if (param=="") {
                param = {};
                param.curPage = 1;
            }
            param.pageSize = 5;
            $.ajax({
                url: "middleProductList",
                type: "get",
                data: param,
                success: function (result) {
                    $("#areaCommment").html(result);
                }
            });
        }

        //首页
        function firstPage() {
            var param = {};
            param.curPage = 1;
            queryList(param);
        }

        //上一页
        function prePage() {
            var curPage = $(".curPage").text();
            if (curPage > 1) {
                curPage--;
                var param = {};
                param.curPage = curPage;
                queryList(param);
            }else {
                alert("已经是第一页了");
            }
        }

        //下一页
        function nextPage() {
            var curPage = $(".curPage").text();
            var totalPageCount = $(".totalPageCount").text();
            if (curPage < totalPageCount) {
                curPage++;
                var param = {};
                param.curPage = curPage;
                queryList(param);
            } else {
                alert("已经是最后一页了");
            }
        }

        //末页
        function endPage() {
            var curPage = $(".curPage").text();
            var totalPageCount = $(".totalPageCount").text();
            if (curPage < totalPageCount) {
                curPage = totalPageCount;
                var param = {};
                param.curPage = curPage;
                queryList(param);
            }
        }
    </script>
</head>
<body>
<div style="background: white;width: 100%;height: 747px" id="areaCommment"></div>
</body>
</html>
