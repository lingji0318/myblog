<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/29
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adx</title>
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
                <li >
                    <a href="dmp_interface">DMP</a>
                </li>
                <li class="active">
                    <a href="adx_interface">ADX</a>
                </li>
            </ul>


            <div class="row clearfix">
                <div class="col-md-8 column">
                    <h3>
                        ADX接口
                    </h3>
                    <textarea cols="50" rows="2" id="adx_url">http://test.s.x.xtgreat.com/cx?d=1&secret=miaozhen1234</textarea>
                    <textarea cols="100" rows="10" id="adx_req"></textarea>
                    <div class="row clearfix">

                        <div class="col-md-12 column">
                            <button type="button" class="btn btn-default btn-info" id="adx_button">调用</button>
                        </div>

                    </div>
                    <textarea cols="100" rows="10" id="adx_res"></textarea>
                </div>
                <div class="col-md-4 column">
                    <h3>
                        adx接口参数
                    </h3>
                    <pre id="out_pre"></pre>
                </div>
            </div>




        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    var adx_json = '{\n' +
        '"version": "1.0",\n' +
        '"pid": "24248",\n' +
        '"action_type": 1,\n' +
        '"device": {\n' +
        '"devicetype": 0,\n' +
        '"os": 0,\n' +
        '"imei_md5": "F1C7976BC455CB548BFC550EB7687F06",\n' +
        '"m_ip": "14.18.52.69",\n' +
        '"m_ua": "Mozilla/5.0(Linux;Android4.0.4;GT-I9220 Build/IMM76D)",\n' +
        '"m_ts": "1374225975",\n' +
        '"m_dvw": 300,\n' +
        '"m_dvh": 250\n' +
        '},\n' +
        '"app": {\n' +
        '"m_app": "wantu",\n' +
        '"m_app_pn": "com.weitu.wantu"\n' +
        '},\n' +
        '"reqid": "123"\n' +
        '}'; //获取json格式内容

    var adx_json_result = JSON.stringify(JSON.parse(adx_json), null, 2);//将字符串转换成json对象

    document.getElementById('out_pre').innerText = adx_json_result ;



    $("#adx_button").click(function () {
        $("#adx_res").val(" ");
        var adx_req=$("#adx_req").val();
        var adx_url=$("#adx_url").val();
        $.ajax({
            data:{
                "adx_req":adx_req,
                "adx_url":adx_url
            },
            type:"POST",
            url:"/main_myblog/adx_controller",

            success:function(msg){
                //alert(msg);
                 var adx_res_json = JSON.stringify(JSON.parse(msg), null, 2);
                $("#adx_res").val(adx_res_json);
            }
        })
    });
</script>



</html>
