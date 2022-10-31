package Common.MidwareConn.HTTPConn;

import Common.Constant.C;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/4/10 19:04
 * @author—Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */

public class HttpCli_HttpClients {

    public static void main(String[] args) throws Exception {
        HttpCli_HttpClients http = new HttpCli_HttpClients();
        System.out.println("Testing 1 - Do Http GET request");
        http.doGet(C.BaiduURLStr);
        System.out.println("\nTesting 2 - Do Http POST request");
        http.doPost(C.BaiduURLStr);
    }

    public String doGet(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            //通过默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            //创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);
            //httpGet.addHeader("Connection", "keep-alive");
            //设置请求头信息
            httpGet.addHeader("Accept", "application/json");
            //配置请求参数
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(Timeout.ofMicroseconds(35000)) //设置连接主机服务超时时间
                    .setConnectionRequestTimeout(Timeout.ofMicroseconds(35000))//设置请求超时时间
                    //.setSocketTimeout(60000)//设置数据读取超时时间
                    .build();
            httpGet.setConfig(requestConfig); //为httpGet实例设置配置
            response = httpClient.execute(httpGet); //执行get请求得到返回对象
            HttpEntity entity = response.getEntity();//通过返回对象获取返回数据
            //通过EntityUtils中的toString方法将结果转换为字符串，后续根据需要处理对应的reponse code
            result = EntityUtils.toString(entity);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return result;
    }

    public String doPost(String url) {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";
        try {
            //创建http请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            //创建请求内容
            String jsonStr = "{\"qry_by\":\"name\", \"name\":\"Tim\"}";
            StringEntity entity = new StringEntity(jsonStr);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return result;
    }
}
