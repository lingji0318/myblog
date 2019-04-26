package interface_toufang;

import java.io.PrintWriter;
import java.net.HttpURLConnection;

import com.alibaba.fastjson.JSON;
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

        public static final String POST_URL = "http://192.168.10.67:9393/api/v2/tag";

        public static String httpURLConnectionPOST(String parm) {//parm 你要post的数据
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
                connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
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
               // System.out.println(sb);
                String sbString = sb.toString();
                //JSONObject json = JSONObject.parseObject(jsonText);
                System.out.println(sbString);

                bf.close(); // 日常关流
                connection.disconnect(); // 销毁连接
                return sbString;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    public static void main(String[] args){
            String result="";
            String canshu="{\n" +
                    "  \"uid\": \"51A95602-458E-45A2-B993-56DBACE58E03\",\n" +
                    "  \"dt\": 1,\n" +
                    "  \"cm\": 0,\n" +
                    "  \"ip\": \"1.1.1.1\",\n" +
                    "  \"os\": \"ios\",\n" +
                    "  \"dmp\": {\n" +
                    "    \"mjn_dmp\": {\n" +
                    "      \"uid\": \"\",\n" +
                    "      \"tags\": {\n" +
                    "        \"\": [\n" +
                    "          \"1938\",\n" +
                    "          \"1940\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"ad_dmp\": {\n" +
                    "      \"uid\": \"\",\n" +
                    "      \"tags\": {\n" +
                    "        \"\": [\n" +
                    "          \"deal1\",\n" +
                    "          \"deal2\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"gt_dmp\": {\n" +
                    "      \"uid\": \"\",\n" +
                    "      \"tags\": {\n" +
                    "        \"\": [\n" +
                    "          \"test_gt_1\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"gm_dmp\": {\n" +
                    "      \"uid\": \"\",\n" +
                    "      \"tags\": {\n" +
                    "        \"\": [\n" +
                    "          \"1079180737\",\n" +
                    "          \"1136406191\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"ten_dmp\": {\n" +
                    "      \"uid\": \"tencent_user_id\",\n" +
                    "      \"tags\": {\n" +
                    "        \"100066\": [\n" +
                    "          \"7\",\n" +
                    "          \"8\"\n" +
                    "        ],\n" +
                    "        \"100067\": [\n" +
                    "          \"9\",\n" +
                    "          \"10\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"mzapi_dmp\": {\n" +
                    "      \"uid\": \"miaozhen_user_id\",\n" +
                    "      \"tags\": {\n" +
                    "        \"token1\": [\n" +
                    "          \"10001\",\n" +
                    "          \"10004\"\n" +
                    "        ],\n" +
                    "        \"token2\": [\n" +
                    "          \"10001\",\n" +
                    "          \"10002\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
             result=test_post.httpURLConnectionPOST(canshu);
             System.out.println(result);

    }
}
