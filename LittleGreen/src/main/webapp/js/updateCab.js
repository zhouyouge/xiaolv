//修改
function updateCab1() {
    var id = $("#ids").val();
    var state = $("#state").val();
    var Address = $("#address").val();
    if (checkParam(id,state,Address)){
        var param = {};
        param.id = id;
        param.state = state;
        param.cabinetAddress = Address;
        $.ajax({
            url:"updateCabinet",
            type:"post",
            data:param,
            success:function (result) {
                if (result==""){
                    alert("修改失败！");
                    location.href="cabinet1.jsp";
                }else {
                    alert("回收柜信息修改成功！");
                    location.href="cabinet1.jsp";
                }
            }
        });
    }
}
function updateCab(id){
    $.ajax({
        url:"updateCab/"+id,
        type:"post",
        success:function (result) {
            $("#comment").html(result);
        }
    });
}
function checkParam(id,state,Address) {
    if (id==""){
        alert("编号不能为空！");
        return false;
    }
    if (state==""){
        alert("回收柜状态不能为空！");
        return false;
    }
    if (Address==""){
        alert("地址不能为空！");
        return false;
    }
    return true;
}