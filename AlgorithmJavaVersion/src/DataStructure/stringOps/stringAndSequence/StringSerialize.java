package DataStructure.stringOps.stringAndSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/19
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 字符串序列化
 * {"a": "value", "b": true, "c": 1} 解析成Map，不要用String # split方法，不要用第三方库
 * 只考虑单层字符串
 */
// todo
public class StringSerialize {

    public Map Serialize(String input) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        char[] chArr = input.toCharArray();
        Object key = null;
        Object value;
        boolean keyFalg = true;
        boolean valueFalg = false;
        StringBuilder sbKey = new StringBuilder();
        StringBuilder sbValue = new StringBuilder();
        for (int i = 0; i < chArr.length; i++) {
            if (checkSymbol(chArr[i]) == 0) {
                continue;
            }
            if (checkSymbol(chArr[i]) == 2) {
                key = sbKey.toString();
                sbKey = new StringBuilder();
                valueFalg = true;
                keyFalg = false;
                continue;
            }
            if (checkSymbol(chArr[i]) == 3) {
                value = sbValue.toString();
                sbValue = new StringBuilder();
                keyFalg = true;
                valueFalg = false;
                map.put(key, value);
                continue;
            }
            if (keyFalg) {
                sbKey.append(chArr[i]);
            }
            if (valueFalg) {
                sbValue.append(chArr[i]);
            }
        }
        return map;
    }

    public static int checkSymbol(char c) {
        switch (c) {
            case '{':
            case '"':
            case ' ':
                return 0;
            case ':':
                return 2;
            case ',':
            case '}':
                return 3;
            default:
                return 1;
        }
    }
}
