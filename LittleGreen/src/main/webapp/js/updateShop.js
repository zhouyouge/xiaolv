//修改
function updateShop1() {
    var id = $("#ids").val();
    var shopName = $("#shopName").val();
    var shopPrice = $("#shopPrice").val();
    if (checkParam(id,shopName,shopPrice)){
        var param = {};
        param.id = id;
        param.shopName = shopName;
        param.shopPrice = shopPrice;
        $.ajax({
            url:"updateShoping",
            type:"post",
            data:param,
            dataType:"json",
            success:function (result) {
                if (result==""){
                    alert("修改失败！");
                    location.href="shop1.jsp";
                } else {
                    alert("回收柜信息修改成功！");
                    location.href="shop1.jsp";
                }
            }
        });
    }
}
function updateShop(id){
    $.ajax({
        url:"updateShops/"+id,
        type:"post",
        success:function (result) {
            $("#comment").html(result);
        }
    });
}
function checkParam(id,shopName,shopPrice) {
    if (id==""){
        alert("编号不能为空！");
        return false;
    }
    if (shopName==""){
        alert("商品名称不能为空！");
        return false;
    }
    if (shopPrice==""){
        alert("商品价格不能为空！");
        return false;
    }
    return true;
}