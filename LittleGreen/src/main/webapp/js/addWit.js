//添加
function addWits() {
    var withdrawUser=$("#withdrawUser").val();
    var money=$("#money").val();
    var withdrawIntegral=$("#Integral").val();
    var putinId=$("#putinId").val();
    if (checkParam(putinId,money,withdrawIntegral,withdrawUser)){
        var param={};
        param.putinId=putinId;
        param.money=money;
        param.withdrawIntegral=withdrawIntegral;
        param.withdrawUser=withdrawUser;
        $.ajax({
            url:"addWithdras",
            type:"post",
            data:param,
            dataType:"json",
            success:function (result) {
                location.href="withdraw.jsp";
                if (result!="") {
                    if (result.result == false) {
                        if (result.flag == 7) {
                            location.href = "index.jsp";
                        }
                        if (result.flag == 0) {
                            alert(result.data);
                        }
                        if (result.flag == 1) {
                            alert(result.data);
                        }
                        if (result.flag == 2) {
                            alert(result.data);
                        }
                        if (result.flag == 3) {
                            alert(result.data);
                        }
                        if (result.flag == 4) {
                            alert(result.data);
                        }
                    } else {
                        if (result.flag == 7) {
                            alert(result.data);
                            //请求销售记录信息列表

                        }
                    }
                }
            }
        });
    }
}

function checkParam(putinId,money,withdrawIntegral,withdrawUser) {
    if (putinId==""){
        alert("投放id不能为空")
        return false;
    }
    if (money==""){
        alert("金额不能为空")
        return false;
    }
    if (withdrawIntegral==""){
        alert("花费积分不能为空")
        return false;
    }
    if (withdrawUser==""){
        alert("提现ID不能为空")
        return false;
    }
    return true;
}
