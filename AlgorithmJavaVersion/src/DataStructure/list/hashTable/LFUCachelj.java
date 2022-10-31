package DataStructure.list.hashTable;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/4
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://mp.weixin.qq.com/s/oXv03m1J8TwtHwMJEZ1ApQ
 * @description 最近最少使用算法
 * LFU，Least Frequently Used
 * LFU相对于LRU而言，多了一个频率统计
 */
public class LFUCachelj implements Cachelj {

    // key 到 val 的映射，KV 表
    private HashMap<Integer, String> kvMap;
    // key 到 freq 的映射，KF 表
    private HashMap<Integer, Integer> keyToFreqMap;
    // freq 到 key 列表的映射，FK 表
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeyMap;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int maxCap;
    int defaultCap = 5;

    public LFUCachelj() {
        this.kvMap = new HashMap<>();
        this.keyToFreqMap = new HashMap<>();
        this.freqToKeyMap = new HashMap<>();
        this.maxCap = defaultCap;
        this.minFreq = 0;
    }

    public LFUCachelj(int capacity) {
        this.kvMap = new HashMap<>();
        this.keyToFreqMap = new HashMap<>();
        this.freqToKeyMap = new HashMap<>();
        this.maxCap = capacity;
        this.minFreq = 0;
    }

    
    public boolean put(int key, String value) {
        if (kvMap.containsKey(key)) {
            //页面插入（更新）
            kvMap.put(key, value);
            //提升freg
            increaseFreq(key);
            return true;
        }
        if (kvMap.size() + 1 > maxCap) { //判断容量
            //页面淘汰
            pageElimination();
        }
        //三个表同时进行更新操作(KV、KF、FK)，需要写成一个方法
        kvMap.put(key, value);
        keyToFreqMap.put(key, 1);
        freqToKeyMap.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeyMap.get(1).add(key);
        this.minFreq = 1;
        return true;
    }

    public String get(int key) {
        if (!kvMap.containsKey(key)) {
            return "";
        }
        //访问率提升一次
        increaseFreq(key);
        return kvMap.get(key);
    }

    
    public boolean delete(int x) {
        return false;
    }

    
    public String getRecent() {
        return null;
    }

    
    public boolean deleteLeast() {
        return false;
    }

    // 提升频率
    private void increaseFreq(int key) {
        // 1、update keyToFreqMap
        int freq = keyToFreqMap.get(key);
        keyToFreqMap.put(key, freq + 1);
        // 2、update freqToKeyMap
        freqToKeyMap.get(freq).remove(key);
        /* 如果 freqToKeyMap 对应的列表空了，移除这个 freq */
        freqToKeyMap.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeyMap.get(freq + 1).add(key);
        // 3、更新 minFreq
        if (freqToKeyMap.get(freq).isEmpty()) {
            freqToKeyMap.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    // 替换操作，页面淘汰
    private void pageElimination() {
        LinkedHashSet<Integer> lfuSet = freqToKeyMap.get(this.minFreq);
        int deleteKey = lfuSet.iterator().next();
        /* 更新 FK 表 */
        lfuSet.remove(deleteKey);
        if (lfuSet.isEmpty()) {
            freqToKeyMap.remove(this.minFreq);
            //此处没需要更新 minFreq 的值
        }
        /* 更新 KV 表 */
        kvMap.remove(deleteKey);
        /* 更新 kF 表 */
        keyToFreqMap.remove(deleteKey);
    }

    // 内部接口：判断缓存是否为空
    public boolean empty() {
        if (true) {
            return true;
        }
        return false;
    }
}
