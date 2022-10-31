package Common.MidwareConn.HTTPConn;


import Common.Constant.C;
import org.junit.Test;

import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/5/2 00:23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */

public class HTTPCliTest {

    @Test
    public void TestHttpCli_HttpClients() throws Exception {
        HttpCli_HttpClients http = new HttpCli_HttpClients();
        System.out.println("Testing 1 - Do Http GET request");
        http.doGet(C.BaiduURLStr);
        System.out.println("\nTesting 2 - Do Http POST request");
        http.doPost(C.BaiduURLStr);
    }

    @Test
    public void TestHttpCli_Stream() {
        HttpCli_Stream cli = new HttpCli_Stream();
        List<String> list = cli.sendGetRequest(C.BaiduURLStr);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
