<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script >
        $(function () {

            $("#btn").click(function () {

                //获取用户名密码
                var serialize = $("#inputForm").serialize();
                console.log(serialize);
                
                //发送ajax
                $.post("${pageContext.request.contextPath}/user/login",serialize,function (result) {
                    if(result.success){//判断
                       /* alert('3秒后自动跳转页面...');*/
                        setTimeout(function () {
                            location.href = "${pageContext.request.contextPath}/message.jsp";
                        },300)
                    }else{
                        alert(result.message);
                    }
                },"JSON");


            });


        });

    </script>
</head>
<body>


    <form action="" id="inputForm">
        用户名: <input type="text" name="user.name"/><br>
        <input type="button" id="btn" value="登录">
    </form>


</body>
</html>
