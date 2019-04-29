import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.io.InputStream ;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;


//get请求传参
public class test_interface {
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            JSONObject json = JSONObject.parseObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
//这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
        String ip = "113.57.244.100";
        String url = "http://api.map.baidu.com/location/ip?ak=32f38c9491f2da9eb61106aaab1e9739&ip="+ip+"&coor=bd09ll";
        JSONObject json = test_interface.readJsonFromUrl(url);
        System.out.println(json.toString());
        System.out.println("经度："+((JSONObject) json.get("content")).getJSONObject("point").get("x"));
        System.out.println("维度："+((JSONObject) json.get("content")).getJSONObject("point").get("y"));
        String city =(String) ((JSONObject) json.get("content")).getJSONObject("address_detail").get("city");
        city = city.replace("市","");
        System.out.println(city);
    }
}

