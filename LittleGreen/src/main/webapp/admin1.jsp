<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script>
    $(function () {
        $.ajax({
            url:"admin",
            type:"get",
            success:function (result) {
                alert("22222");
                alert(result);
                $("#comment").html(result);

            }
        });
    });
</script>
<html id="comment"></html>