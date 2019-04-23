<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试评论</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {


            //初始化页面数据
            initData();
            //添加评论
            $("#btn").click(function () {
                //获取评论信息
                var message = $("#message").val();
                //添加评论
                $.post("${pageContext.request.contextPath}/user/save",{"message.content":message},function (result) {
                    initData();
                });



            });

        });

        function initData(){
            //发送ajax请求查询所有评论
            $.get("${pageContext.request.contextPath}/user/findAll",function (result) {
                $("#ul").empty();
                //遍历
                $.each(result,function (i,message) {
                    var li = $("<li/>").text(message.content);
                    var span = $("<span/>").css("color","red").text("    票数: "+message.counts+"   ");
                    var a = $("<a/>").text("点击支持").attr("href","javascript:;");
                    li.append(span).append(a);
                    $("#ul").append(li);

                })
            },"JSON");
        }
    </script>
</head>
<body>

    <h1>欢迎:${sessionScope.user.name}</h1>
    <hr>
    <img src="${pageContext.request.contextPath}/1.jpg" style="width: 400px;height: 300px;" alt="">
    <hr>
    <form action="">
        评论: <input type="text" id="message" name="message.content"> <input type="button" id="btn" value="提交">
    </form>
    <hr>
    <ul id="ul">

    </ul>
</body>
</html>
