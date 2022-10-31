package DataStructure.list.hashTable;

import DataStructure.list.Nodelj;
import java.util.HashMap;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/28
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247486428&idx=1&sn=3611a14535669ba3372c73e24121247c&chksm=9bd7f5d4aca07cc28c02c3411d0633fc12c94c2555c08cbfaa2ccd50cc2d25160fb23bccce7f&scene=21#wechat_redirect
 * @description 最近最久未使用算法
 * LRU: The Least Recently Used
 */

public class LRUCachelj implements Cachelj {

    private DuplexLinkedListljImpl cacheList;
    private HashMap<Integer, Nodelj> map;
    public int maxCap;
    int defaultCap = 5;

    public LRUCachelj() {
        this.cacheList = new DuplexLinkedListljImpl();
        this.map = new HashMap<>(32);
        this.maxCap = defaultCap;
    }

    public LRUCachelj(int cap) {
        this.cacheList = new DuplexLinkedListljImpl();
        this.map = new HashMap<>(32);
        this.maxCap = cap;
    }

    public boolean put(int key, String value) {
        if (map.containsKey(key)) {
            // 更新值
            if (value.equals(map.get(key).value)) {
                map.get(key).value = value;
            }
            // 更新先后顺序
            makeRecently(map.get(key));
            return true;
        }
        //容量是否满
        if (cacheList.getSize() == maxCap) {
            deleteLeast();
        }
        addRecently(key, value);
        return true;
    }

    public String get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Nodelj node = map.get(key);
        makeRecently(node);
        return node.value;
    }

    //最近的元素都插在队尾
    public String getRecent() {
        String value = null;
        if (cacheList.getSize() != 0) {
            Nodelj node = cacheList.getLeast();
            value = node.value;
            makeRecently(node);
        }
        return value;
    }

    public boolean delete(int x) {
        Nodelj node = map.get(x);
        //双删除
        cacheList.delete(node);
        map.remove(x);
        return true;
    }

    //删除最久未使用
    public boolean deleteLeast() {
        Nodelj node = cacheList.deleteOld();
        int key = node.key;
        map.remove(key);
        return true;
    }

    //更新最近元素
    public void makeRecently(Nodelj node) {
        cacheList.delete(node);
        cacheList.insertLast(node);
    }

    //新增最近元素
    public void addRecently(int x, String value) {
        Nodelj node = new Nodelj(x, value);
        //双增加
        cacheList.insertLast(node);
        map.put(x, node);
    }

    // 判断缓存是否为空
    public boolean empty() {
        return cacheList.linkedSize == 0;
    }
}
