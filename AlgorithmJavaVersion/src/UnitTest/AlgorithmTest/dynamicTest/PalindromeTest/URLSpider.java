package UnitTest.AlgorithmTest.dynamicTest.PalindromeTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//stat the all the alphabet count in this url: Lorem Ipsum - All the facts - Lipsum generator ,
//and sort with DESC order and analysis the time complexity of your code
public class URLSpider {

    static Map<Character, Integer> alphaStatisticMap;

    public static void main(String[] args) throws IOException {
        URLSpider m = new URLSpider();

        alphaStatisticMap = new HashMap<>();
        alphaStatisticMap.put('c', 4);
        alphaStatisticMap.put('a', 44);
        alphaStatisticMap.put('b', 41);
        int[] array = m.sort(alphaStatisticMap);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        /*m.CountAlpha("https://www.lipsum.com");*/
    }

    public int[] CountAlpha(String url) throws IOException {
        GetUrlContent(url);
        int[] array = sort(alphaStatisticMap);
        return array;
    }

    public int[] sort(Map<Character, Integer> map) {
        int[] array = new int[map.size()];
        int count = 0;
        for (Character c : map.keySet()) {
            int point = count;
            while (point >= 0) {
                if (map.get(c) > array[point]) {
                    array[point + 1] = array[point];
                }
                point--;
            }
            array[point + 1] = map.get(c);
            count++;
        }
        return array;
    }

    public void GetUrlContent(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuffer sb = new StringBuffer();
        try {

            //构建一URL对象
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF8"));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {

                sb.append(line);
            }
            in.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return;
    }

    //zhangyong.lu@clobotics.com

}
