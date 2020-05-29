<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/shopfenye.js"></script>
<script type="text/javascript" src="js/updateShop.js"></script>
<html>
<head>
    <title>商城信息</title>
    <script>
        //删除回收柜信息
        function deleteShop(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"delShop",
                    type:"get",
                    data:"id="+id,
                    dataType:"json",
                    success:function (result) {
                        if (result==""){
                            alert("删除失败！");
                            location.href="shop1.jsp";
                        }else {
                            alert("删除成功！");
                            queryList("");
                            location.href="shop1.jsp";
                        }
                    }
                });
            }
        }
    </script>
</head>
<body>
<div style="background:white ;width: 100%;height: 100%;" id="comment">

</div>
</body>
</html>
