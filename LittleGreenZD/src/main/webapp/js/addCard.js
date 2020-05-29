//添加
function addCard() {
    var id = $("#id").val();
    var ICUserName = $("#ICUserName").val();
    var ICIntegral = $("#ICIntegral").val();
    var phone = $("#phone").val();
    var userAddress = $("#userAddress").val();
    if (checkParam(id,ICUserName,ICIntegral,phone,userAddress)){
        var param = {};
        param.id = id;
        param.ICUserName = ICUserName;
        param.ICIntegral = ICIntegral;
        param.phone = phone;
        param.userAddress=userAddress;
        $.ajax({
            url: "card",
            type: "post",
            data: param,
            dataType:"json",
            success: function (result) {
                alert("添加成功");
                location.href="cardlist1.jsp";
            }
        });
    }
}
function checkParam(id,ICUserName,ICIntegral,phone,userAddress) {
    if (id==""){
        alert("IC卡号不能为空！");
        return false;
    }
    if (ICUserName==""){
        alert("IC卡用户名不能为空！");
        return false;
    }
    if (ICIntegral==""){
        alert("积分余额不能为空！");
        return false;
    }
    if (phone==""){
        alert("IC卡用户电话不能为空！")
        return false;
    }
    if (userAddress==""){
        alert("ic卡用户住址不能为空！")
        return false;
    }
    return true;
}