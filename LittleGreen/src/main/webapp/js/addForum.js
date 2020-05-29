function addFors() {
    var forumName =$("#forumName").val();
    var forumContent =$("#forumContent").val();
    var uploader =$("#uploader").val();
    if (chekParam(forumName,forumContent,uploader)){
        var param={};
        param.forumName=forumName;
        param.forumContent=forumContent;
        param.uploader=uploader;
        $.ajax({
           url:"forumList",
           type:"post",
           data:param,
           dataType:"json",
           success:function (result) {
               alert("添加成功！");
               location.href="Forum.jsp";
           }

        });
    }
}

function chekParam(forumName,forumContent,uploader) {
    if (forumName==""){
        alert("主题不能为空!!")
        return false;
    }
    if (forumContent==""){
        alert("发布内容不能为空!!")
        return false;
    }
    if (uploader==""){
        alert("姓名不能为空!!")
        return false;
    }
    return true;
}