<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/25
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dmp</title>
    <title>toufang</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li >
                    <a href="index">投放</a>
                </li>
                <li class="active">
                    <a href="dmp_interface">DMP</a>
                </li>
                <li class="disabled">
                    <a href="#">待续</a>
                </li>
            </ul>


            <div class="row clearfix">
                <div class="col-md-8 column">
                    <h3>
                        dmp接口
                    </h3>
                    <textarea cols="50" rows="2" id="dmp_url">http://192.168.10.67:9393/api/v2/tag</textarea>
                    <textarea cols="100" rows="10" id="dmp_req"></textarea>
                    <div class="row clearfix">

                        <div class="col-md-12 column">
                            <button type="button" class="btn btn-default btn-info" id="dmp_button">调用</button>
                        </div>

                    </div>
                    <textarea cols="100" rows="10" id="dmp_res"></textarea>
                </div>
                <div class="col-md-4 column">
                    <h3>
                        dmp接口参数
                    </h3>
                    <pre id="out_pre"></pre>
                </div>
            </div>




        </div>
    </div>
</div>
</body>

<script type="text/javascript">



    var dmp_json = '{\n' +
        '    "uid": "51A95602-458E-45A2-B993-56DBACE58E03",\n' +
        '    "dt": 1,\n' +
        '    "cm": 0,\n' +
        '    "ip": "1.1.1.1",\n' +
        '    "os": "ios",\n' +
        '    "dmp": {\n' +
        '        "mjn_dmp": {\n' +
        '            "uid": "",\n' +
        '            "tags": {\n' +
        '                "": [\n' +
        '                    "1938",\n' +
        '                    "1940"\n' +
        '                ]\n' +
        '            }\n' +
        '        },\n' +
        '        "ad_dmp": {\n' +
        '            "uid": "",\n' +
        '            "tags": {\n' +
        '                "": [\n' +
        '                    "deal1",\n' +
        '                    "deal2"\n' +
        '                ]\n' +
        '            }\n' +
        '        },\n' +
        '        "gt_dmp": {\n' +
        '            "uid": "",\n' +
        '            "tags": {\n' +
        '                "": [\n' +
        '                    "test_gt_1"\n' +
        '                ]\n' +
        '            }\n' +
        '        },\n' +
        '        "gm_dmp": {\n' +
        '            "uid": "",\n' +
        '            "tags": {\n' +
        '                "": [\n' +
        '                    "1079180737",\n' +
        '                    "1136406191"\n' +
        '                ]\n' +
        '            }\n' +
        '        },\n' +
        '        "ten_dmp": {\n' +
        '            "uid": "tencent_user_id",\n' +
        '            "tags": {\n' +
        '                "100066": [\n' +
        '                    "7",\n' +
        '                    "8"\n' +
        '                ],\n' +
        '                "100067": [\n' +
        '                    "9",\n' +
        '                    "10"\n' +
        '                ]\n' +
        '            }\n' +
        '        },\n' +
        '        "mzapi_dmp": {\n' +
        '            "uid": "miaozhen_user_id",\n' +
        '            "tags": {\n' +
        '                "token1": [\n' +
        '                    "10001",\n' +
        '                    "10004"\n' +
        '                ],\n' +
        '                "token2": [\n' +
        '                    "10001",\n' +
        '                    "10002"\n' +
        '                ]\n' +
        '            }\n' +
        '        }\n' +
        '    }\n' +
        '}'
    var dmp_json_result = JSON.stringify(JSON.parse(dmp_json), null, 2);//将字符串转换成json对象

    document.getElementById('out_pre').innerText = dmp_json_result ;


    $("#dmp_button").click(function () {
        var dmp_req=$("#dmp_req").val();
        var dmp_url=$("#dmp_url").val();
        $.ajax({
            data:{
                "dmp_req":dmp_req,
                "dmp_url":dmp_url
            },
            type:"POST",
            url:"/main_myblog/dmp_controller",

            success:function(msg){
                //alert(msg);
                $("#dmp_res").val(msg);
            }
        })
    });

</script>
</html>
