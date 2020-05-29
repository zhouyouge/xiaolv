<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/updateCab.js"></script>

<html>
<head>
    <title>回收柜信息</title>
    <script>
        //删除回收柜信息
        function deleteCab(id) {
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"delCab",
                    type:"get",
                    data:"id="+id,
                    dataType:"json",
                    success:function (result) {
                        if (result==""){
                            if (result.result==false){
                                location.href="cabinet.jsp";
                            } else {
                                if (result.flag==1){
                                    queryList("");
                                }
                            }
                        }else {
                            alert("删除成功！")
                            location.href="cabinet1.jsp";
                            queryList("");
                        }
                    }
                });
            }
        }
        function chaxun() {
            var state = $("#cabinet1").val();
            /*var address= $("#address").val();
            var createTime = $("#createTime").val();*/
            var param={};
            param.state = state;
            /*param.cabinetAddress = address;
            param.createTime = createTime;*/
            alert(state);
            $.ajax({
                url:"cabinetBBB",
                type:"get",
                data:param,
                success:function (result) {
                    alert(param);
                    alert(JSON.stringify(result));
                    queryList(param);
                }
            });
        }
    </script>
    <script type="text/javascript" src="js/cabfenye.js"></script>
</head>
<body>
<div style="background:white ;width: 100%;height: 100%;" id="comment">

</div>
</body>
</html>
