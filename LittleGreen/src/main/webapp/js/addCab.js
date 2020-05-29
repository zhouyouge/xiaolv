//添加
function addCab() {
    var id = $("#ids").val();
    var state = $("#state").val();
    var Address = $("#address").val();
    if (checkParam(id,state,Address)){
        var param = {};
        param.id = id;
        param.state = state;
        param.cabinetAddress = Address;
        $.ajax({
            url:"addCabinet",
            type:"post",
            data:param,
            dataType:"json",
            success:function (result) {
                alert("添加成功！");
                location.href="cabinet1.jsp";
            }
        });
    }
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