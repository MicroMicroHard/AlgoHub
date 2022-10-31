package UnitTest.DataStructureTest.stringANDlineTest.sequenceANDstringTest;

import DataStructure.stringOps.stringAndSequence.StringSerialize;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/19
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 字符串序列化
 * {"a": "value", "b": true, "c": 1} 解析成Map，不要用String # split方法，不要用第三方库
 * 只考虑单层字符串
 */

public class StringSerializeTest {

    @Test
    // todo
    public void TestStringSerialize() {
        test(new StringSerialize());
    }

    public void test(StringSerialize stringSerialize) {
        Map targetMap = stringSerialize.Serialize(demo01);

    }

    String demo01 = "{\"a\": \"value\", \"b\": true, \"c\": 1}";
    Map<Object, Object> map01 = new HashMap() {
    };
}
