package UnitTest.DataStructureTest.arrayAndListTest.hashTableTest;

import DataStructure.list.hashTable.LRUCachelj;
import DataStructure.list.hashTable.Cachelj;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/28
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最近最久未使用算法 测试案例
 */
public class LRUCacheljTest {

    @Test
    public void testLRUCache() {
        test(new LRUCachelj(5));
    }

    public void test(Cachelj cache) {
        String value = cache.getRecent();
        assert value == null;
        boolean flag = cache.empty();
        assert flag;
        cache.put(key01, value01);
        cache.put(key02, value02);
        cache.put(key03, value03);
        cache.put(key04, value04);
        cache.put(key05, value05);
        cache.put(key06, value06);
        //此时顺序 6->5->4->3->2
        value = cache.get(key03);
        assert value03.equals(value);
        //此时顺序 3->6->5->4->2
        value = cache.getRecent();
        assert value03.equals(value);
        cache.put(key07, value07);
        //此时顺序 7->3->6->5->4
        value = cache.getRecent();
        assert value07.equals(value);

        value = cache.get(key05);
        //此时顺序 5->7->3->6->4
        assert value05.equals(value);
        value = cache.get(key01);
        assert null == value;
        cache.put(key06, value06_new);
        value = cache.getRecent();
        assert value06_new.equals(value);
        assert !cache.empty();

        flag = cache.delete(key06);
        assert flag;
        //此时顺序 5->7->3->4
        value = cache.getRecent();
        assert value05.equals(value);
        flag = cache.deleteLeast();
        assert flag;
        flag = cache.deleteLeast();
        assert flag;
        //此时顺序 5->7
        assert value05 == cache.getRecent();
        assert !cache.empty();
        cache.put(key03, value03_new);
        value = cache.get(key03);
        assert value == value03_new;
        cache.deleteLeast();
        cache.deleteLeast();
        cache.deleteLeast();
        assert cache.empty();
    }

    int key01 = 1;
    int key02 = 2;
    int key03 = 3;
    int key04 = 4;
    int key05 = 5;
    int key06 = 6;
    int key07 = 7;
    String value01 = "111111";
    String value02 = "222222";
    String value03 = "333333";
    String value03_new = "333333_new";
    String value04 = "444444";
    String value05 = "55555";
    String value06 = "66666";
    String value06_new = "66666_New";
    String value07 = "77777";
}
