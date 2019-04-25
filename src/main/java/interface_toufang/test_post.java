package interface_toufang;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.io.InputStream ;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.io.OutputStreamWriter;

public class test_post {

        public static final String POST_URL = "http://y051.ad99.cc:9001/ads?d=1";

        public static void httpURLConnectionPOST(String parm) {//parm 你要post的数据
            PrintWriter out = null;
            try {
                URL url = new URL(POST_URL);
                // 将url以open方法返回的urlConnection 连接强转为HttpURLConnection连接
                // (标识一个url所引用的远程对象连接)
                // 此时cnnection只是为一个连接对象,待连接中
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // 设置连接输出流为true,默认false (post请求是以流的方式隐式的传递参数)
                connection.setDoOutput(true);
                // 设置连接输入流为true
                connection.setDoInput(true);
                // 设置请求方式为post
                connection.setRequestMethod("POST");
                // post请求缓存设为false
                connection.setUseCaches(false);
                // 设置该HttpURLConnection实例是否自动执行重定向
                connection.setInstanceFollowRedirects(true);
                // 设置请求头里面的各个属性 (以下为设置内容的类型)
                // application/x-javascript text/xml->xml数据
                // application/x-javascript->json对象
                // application/x-www-form-urlencoded->表单数据
                // text/plain->raw格式
                // ;charset=utf-8 必须要，不然会出现乱码
                //该样例使用json对象进行请求
                connection.setRequestProperty("Content-Type", "application/x-javascript;charset=utf-8");
                // 建立连接
                connection.connect();
                // 创建输入输出流,用于往连接里面输出携带的参数,记得设置参数编码格式
                OutputStreamWriter outWriter =
                        new OutputStreamWriter(connection.getOutputStream(), "utf-8");
                out = new PrintWriter(outWriter);
                // 将参数输出到连接
                out.print(parm);
                // 输出完成后刷新并关闭流
                out.flush();
                out.close();
                System.out.println(connection.getResponseCode());// 不是200的请跳楼
                // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
                BufferedReader bf =
                        new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;
                StringBuilder sb = new StringBuilder(); // 用来存储响应数据

                // 循环读取流,若不到结尾处
                while ((line = bf.readLine()) != null) {
                    sb.append(line).append(System.getProperty("line.separator"));
                }
                System.out.println(sb);
                bf.close(); // 日常关流
                connection.disconnect(); // 销毁连接

            } catch (Exception e) {
                e.printStackTrace();
            }
           // return sb.toString();
        }
    public static void main(String[] args){
            String canshu="{\n" +
                    "    \"id\": \"y051-test-t24-1468477072-0-605\",\n" +
                    "    \"site\": {\n" +
                    "        \"name\": \"youku\",\n" +
                    "        \"ref\": \"\",\n" +
                    "        \"content\": {\n" +
                    "            \"title\": \"剧目定向\"\n" +
                    "        },\n" +
                    "        \"page\": \"https://www.youku.com\",\n" +
                    "        \"cat\": [\n" +
                    "            \"IAB1\",\n" +
                    "            \"IAB2\",\n" +
                    "            \"IAB3\"\n" +
                    "        ]\n" +
                    "    },\n" +
                    "    \"device\": {\n" +
                    "        \"devicetype\": 0,\n" +
                    "        \"reqlip\": \"59.108.32.2\",\n" +
                    "        \"ip\": \"59.108.43.2\",\n" +
                    "        \"ua\": \"Mozilla/5.0(iPhone;CPUiPhoneOS6_0likeMacOSX)AppleWebKit/536.26(KHTML,likeGecko)Version/6.0Mobile/10A403Safari/8536.25\",\n" +
                    "        \"didmd5\": \"04752ed011e4d27caf12a79a94d2029f\",\n" +
                    "        \"dpidmd5\": \"2FB25AAC4555D7FFC89CA998CCE00ECC\",\n" +
                    "        \"os\": \"Android\",\n" +
                    "        \"ext\": {\n" +
                    "            \"idfa\": \"8B6A3BFA-3E4A-4CFC-A2B1-2BBDD9A01C39\",\n" +
                    "            \"mac\": \"DC7D41E352D13D60765414D53F40BC25\",\n" +
                    "            \"macmd5\": \"DC7D41E352D13D60765414D53F40BC25\"\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"user\": {},\n" +
                    "    \"app\": {\n" +
                    "        \"name\": \"test_app\",\n" +
                    "        \"ext\": {\n" +
                    "            \"deeplink\": 0\n" +
                    "        },\n" +
                    "        \"bundle\": \"com.test.cn\",\n" +
                    "        \"cat\": []\n" +
                    "    },\n" +
                    "    \"ext\": {\n" +
                    "        \"media_source\": 1,\n" +
                    "        \"sourceid\": 4\n" +
                    "    },\n" +
                    "    \"imp\": [\n" +
                    "        {\n" +
                    "            \"id\": \"2ea18010a5634ad3abaf38a412f9717b\",\n" +
                    "            \"tagid\": \"24248\",\n" +
                    "            \"bidfloor\": 1,\n" +
                    "            \"banner\": {\n" +
                    "                \"w\": 300,\n" +
                    "                \"h\": 250,\n" +
                    "                \"pos\": 4,\n" +
                    "                \"mimes\": [\n" +
                    "                    \"image/jpg\"\n" +
                    "                ]\n" +
                    "            },\n" +
                    "            \"pmp\": {\n" +
                    "                \"deals\": [\n" +
                    "                    {\n" +
                    "                        \"id\": \"479770\",\n" +
                    "                        \"at\": 1,\n" +
                    "                        \"bidfloor\": 10,\n" +
                    "                        \"wseat\": [\n" +
                    "                            \"test\"\n" +
                    "                        ],\n" +
                    "                        \"at\":1,\n" +
                    "                        \"media_source\":1\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"private_auction\": 0\n" +
                    "            }\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
        test_post.httpURLConnectionPOST(canshu);

    }
}
