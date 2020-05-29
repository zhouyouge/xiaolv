//添加
function addShop() {
    var id = $("#ids").val();
    var shopName = $("#shopName").val();
    var shopPrice = $("#shopPrice").val();
    if (checkParam(id,shopName,shopPrice)){
        var param = {};
        param.id = id;
        param.shopName = shopName;
        param.shopPrice = shopPrice;
        $.ajax({
            url:"addShop",
            type:"post",
            data:param,
            dataType:"json",
            success:function (result) {
                alert("添加成功！");
                location.href="shop1.jsp";
            }
        });
    }
}
function checkParam(id,shopName,shopPrice) {
    if (id==""){
        alert("商品编号不能为空！");
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