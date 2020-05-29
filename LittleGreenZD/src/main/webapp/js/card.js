$(function (){
    //分页查询
    queryList("");
});
function queryList(param) {
    if (param==""){
        param = {};
        //从下标1页码开始
        param.curPage=1;
    }
    //页尺寸
    param.pageSize=5;
    $.ajax({
        url:"cardlist",
        type:"get",
        data:param,
        success:function (result) {
            $("#comment3").html(result);

        }
    });
}
//首页
function firstPage() {
    var param = {};
    param.curPage = 1;
    queryList(param);
}
//上一页
function prePage() {
    var curPage = $(".curPage").text();
    if (curPage>1){
        curPage--;
        var param = {};
        param.curPage = curPage;
        queryList(param);
    }
}
//下一页
function nextPage() {
    var curPage = $(".curPage").text();
    var totalPageCount = $(".totalPageCount").text();

    if (curPage<totalPageCount){
        curPage++;
        var param = {};
        param.curPage = curPage;
        queryList(param);
    } else {
        alert("别往下翻了，已经是最后一页了！")
    }
}
//末页
function endPage() {
    var curPage = $(".curPage").text();
    var totalPageCount = $(".totalPageCount").text();
    if (curPage<totalPageCount){
        curPage = totalPageCount;
        var param = {};
        param.curPage = curPage;
        queryList(param);
    }
}

function updateCard(id) {
    window.parent.location.href="http://localhost:8082/index.jsp?name='updateCard1.jsp'&&id="+id;
}

function xiuga1(id){
    $.ajax({
        url:"updateCard",
        type:"get",
        data:"id="+id,
        success:function (result) {
            $("#comment5").html(result);
        }
    });

}
