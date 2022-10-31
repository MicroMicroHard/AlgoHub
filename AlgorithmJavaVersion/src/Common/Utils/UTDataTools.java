package Common.Utils;

import Common.Conf.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/7/6 00:24
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description
 * 1、判断相等
 * 2、转换
 * 3、打印
 * 4、排序
 * 5、复制
 * @blogURL
 */

public class UTDataTools {

    Config config = new Config();

    public boolean preCheck(String[] mock_data_input, String[] mock_data_output, String className) {
        if (mock_data_input.length != mock_data_output.length) {
            System.out.println("入参出参数量不一致，请检查");
            return false;
        }
        Map<String, Boolean> duplicateMap = new HashMap();
        for (String input : mock_data_input) {
            String uniqueKey = input + className;
            if (duplicateMap.containsKey(uniqueKey)) {
                System.out.printf("入参和className组成的 uniqueKey 相同，请检查：%s", uniqueKey);
                return false;
            }
            duplicateMap.put(uniqueKey, true);
        }
        return true;
    }

    /*public void PrintSplit(String name) {
        String splitSymbol = "===============";
        String s = String.format("%50s %s %s", splitSymbol, name, splitSymbol);
        System.out.println(s);
    }*/
}
