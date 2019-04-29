<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/22
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>toufang</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">投放</a>
                </li>
                <li>
                    <a href="dmp_interface">DMP</a>
                </li>
                <li class="disabled">
                    <a href="#">待续</a>
                </li>
            </ul>
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <h3>
                        投放接口
                    </h3>
                    <textarea cols="50" rows="2" id="toufang_url">http://y051.ad99.cc:9001/ads?d=1</textarea>
                    <textarea cols="100" rows="10" id="toufang_req"></textarea>
                    <div class="row clearfix">

                        <div class="col-md-12 column">
                            <button type="button" class="btn btn-default btn-info" id="toufang_button">调用</button>
                        </div>

                    </div>
                    <textarea cols="100" rows="10" id="toufang_res"></textarea>
                </div>
                <div class="col-md-4 column">
                    <h3>
                        投放接口参数
                    </h3>
                    <pre id="out_pre"></pre>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript">

    var toufang_json = '{\n' +
        '                        "id": "y051-test-t24-1468477072-0-605",\n' +
        '                        "site": {\n' +
        '                        "name": "youku",\n' +
        '                        "ref": "",\n' +
        '                        "content": {\n' +
        '                        "title": "jumutest"\n' +
        '                        },\n' +
        '                        "page": "https://www.youku.com",\n' +
        '                        "cat": [\n'   +
        '                        "IAB1",\n' +
        '                        "IAB2",\n' +
        '                        "IAB3"\n' +
        '                        ]\n' +
        '                        },\n' +
        '                        "device": {\n' +
        '                        "devicetype": 0,\n' +
        '                        "reqlip": "59.108.32.2",\n' +
        '                        "ip": "59.108.43.2",\n' +
        '                        "ua": "Mozilla/5.0(iPhone;CPUiPhoneOS6_0likeMacOSX)AppleWebKit/536.26(KHTML,likeGecko)Version/6.0Mobile/10A403Safari/8536.25",\n' +
        '                        "didmd5": "04752ed011e4d27caf12a79a94d2029f",\n' +
        '                        "dpidmd5": "2FB25AAC4555D7FFC89CA998CCE00ECC",\n' +
        '                        "os": "Android",\n' +
        '                        "ext": {\n' +
        '                        "idfa": "8B6A3BFA-3E4A-4CFC-A2B1-2BBDD9A01C39",\n' +
        '                        "mac": "DC7D41E352D13D60765414D53F40BC25",\n' +
        '                        "macmd5": "DC7D41E352D13D60765414D53F40BC25"\n' +
        '                        }\n' +
        '                        },\n' +
        '                        "user": {},\n' +
        '                        "app": {\n' +
        '                        "name": "test_app",\n' +
        '                        "ext": {\n' +
        '                        "deeplink": 0\n' +
        '                        },\n' +
        '                        "bundle": "com.test.cn",\n' +
        '                        "cat": []\n' +
        '                        },\n' +
        '                        "ext": {\n' +
        '                        "media_source": 1,\n' +
        '                        "sourceid": 4\n' +
        '                        },\n' +
        '                        "imp": [\n' +
        '                        {\n' +
        '                        "id": "2ea18010a5634ad3abaf38a412f9717b",\n' +
        '                        "tagid": "24248",\n' +
        '                        "bidfloor": 1,\n' +
        '                        "banner": {\n' +
        '                        "w": 300,\n' +
        '                        "h": 250,\n' +
        '                        "pos": 4,\n' +
        '                        "mimes": [\n' +
        '                        "image/jpg"\n' +
        '                        ]\n' +
        '                        },\n' +
        '                        "pmp": {\n' +
        '                        "deals": [\n' +
        '                        {\n' +
        '                        "id": "479770",\n' +
        '                        "at": 1,\n' +
        '                        "bidfloor": 10,\n' +
        '                        "wseat": [\n' +
        '                        "test"\n' +
        '                        ],\n' +
        '                        "at":1,\n' +
        '                        "media_source":1\n' +
        '                        }\n' +
        '                        ],\n' +
        '                        "private_auction": 0\n' +
        '                        }\n' +
        '                        }\n' +
        '                        ]\n' +
        '                        }'; //获取json格式内容

    var toufang_json_result = JSON.stringify(JSON.parse(toufang_json), null, 2);//将字符串转换成json对象

    document.getElementById('out_pre').innerText = toufang_json_result ;



    $("#toufang_button").click(function () {
        $("#toufang_res").val(" ");
        var toufang_req=$("#toufang_req").val();
        var toufang_url=$("#toufang_url").val();
        $.ajax({
             data:{
                 "toufang_req":toufang_req,
                 "toufang_url":toufang_url
             },
             type:"POST",
             url:"/main_myblog/toufang_controller",

            success:function(msg){
                 //alert(msg);
               // var toufang_res_json = JSON.stringify(JSON.parse(msg), null, 2);
                $("#toufang_res").val(msg);
            }
        })
    });
</script>
</html>
