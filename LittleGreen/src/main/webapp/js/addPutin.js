//添加
function addPutin() {
    var putUser = $("#putUser").val();
    var putKG = $("#putKG").val();
    var getIntegral = $("#getIntegral").val();
    var putAddress = $("#putAddress").val();
    var userId = $("#userId").val();
    if (checkParam(putUser,putKG,getIntegral,putAddress,userId)){
        var param = {};
        param.putUser = putUser;
        param.putKG = putKG;
        param.getIntegral = getIntegral;
        param.putAddress = putAddress;
        param.userId=userId;
        $.ajax({
            url: "addPut",
            type: "post",
            data: param,
            dataType:"json",
            success: function (result) {
                alert("添加成功");
                location.href="PutinList1.jsp";
            }
        });
    }
}
function checkParam(putUser,putKG,getIntegral,putAddress,userId) {
    if (putUser==""){
        alert("投放人不能为空！");
        return false;
    }
    if (putKG==""){
        alert("投放重量不能为空！");
        return false;
    }
    if (getIntegral==""){
        alert("获取积分不能为空！");
        return false;
    }
    if (putAddress==""){
        alert("投放地址不能为空！")
        return false;
    }
    if (userId==""){
        alert("用户ID不能为空！")
        return false;
    }
    return true;
}