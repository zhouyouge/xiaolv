<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/card.js"></script>
    <script>
        $(function () {
            var id = <%=  session.getAttribute("id2")%>;
            if (id != null) {
                xiuga1(id);
            }
        });
    </script>
    <title>修改IC卡信息</title>
</head>
<body>
<div style="background:white ;width: 100%;height: 747px;" id="comment5"></div>
</body>
</html>
