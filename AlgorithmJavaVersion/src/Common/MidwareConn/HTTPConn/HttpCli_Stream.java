package Common.MidwareConn.HTTPConn;

import Common.Constant.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/4/10 19:00
 * @author—Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */

public class HttpCli_Stream {

    public static void main(String[] args) {
        HttpCli_Stream cli = new HttpCli_Stream();
        List<String> list = cli.sendGetRequest(C.BaiduURLStr);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> sendGetRequest(String URLStr) {
        List<String> list = new ArrayList<>();
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL(URLStr);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setAllowUserInteraction(false);
            isr = new InputStreamReader(url.openStream());
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 拼接get请求的url请求地址
     */
    public static String buildGetUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        return builder.toString();
    }


}
