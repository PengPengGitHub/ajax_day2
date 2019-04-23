<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试省市区联动效果</title>
    <style>
        select {
            width: 140px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {

            //发送ajax请求展示所有省份数据
            $.post("${pageContext.request.contextPath}/province/findAll", function (result) {
                //遍历
                $.each(result, function (i, prov) {
                    var option = $("<option/>").text(prov.name).val(prov.code);
                    $("#province").append(option);
                });
                //调用省份改变事件
                $("#province").change();
            }, "JSON");


            //当省份改变时查询当前省份下的城市信息
            $("#province").change(function () {
                //获取当前选中省份信息
                var provinceCode = $(this).val();
                //清空上一省份城市信息
                $("#city").empty();
                //发送ajax请求获取当前省份的城市信息
                $.get("${pageContext.request.contextPath}/province/findCityByProvinceCode", {code: provinceCode}, function (result) {
                    //遍历所有市的数据
                    $.each(result, function (i, city) {
                        var option = $("<option/>").text(city.name).val(city.code);
                        $("#city").append(option);
                    });
                    //调用市的改变事件
                    $("#city").change();
                }, "JSON");
            });

            //绑定城市的改变事件查询对应的所有区
            $("#city").change(function () {
                //获取当前的城市编号
                var cityCode = $(this).val();
                //清空原有区的数据
                $("#area").empty();
                //发送ajax请求获取所有区域信息
                $.ajax({
                    url:"${pageContext.request.contextPath}/province/findByCityCode",
                    type:"POST",
                    data:{code:cityCode},
                    dataType:"JSON",
                    success:function (result) {
                        $.each(result,function (i,area) {
                           var option = $("<option/>").text(area.name).val(area.code);
                           $("#area").append(option);
                        });
                    }
                })

            });


        });
    </script>
</head>
<body>

省: <select id="province"></select>
市: <select id="city"></select>
区: <select id="area"></select>

</body>
</html>