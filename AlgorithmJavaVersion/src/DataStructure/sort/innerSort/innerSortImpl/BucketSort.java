package DataStructure.sort.innerSort.innerSortImpl;

import DataStructure.sort.innerSort.ArraySortINTF;
import DataStructure.list.Nodelj;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-22 05:03:35
 * @author-Email micromicrohard@outlook.com
 * @description 桶排序
 * 首先定义桶的数量
 * 将数组按照桶的数量，分成若干堆
 * 每一堆内进行插入排序（注意到此处是）
 */

public class BucketSort implements ArraySortINTF {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public void sortMethod(int[] array) {
        //判空
        if (!check(array)) {
            return;
        }
        //桶初始值设定为10
        int defaultBucketSize = 10;
        bucketSort(array, defaultBucketSize);
    }

    private void bucketSort(int[] array, int bucketsize) {
        //创建桶，注意对象数组初始化一定要创建对象，否则为空
        Nodelj[] hashTableNodes = new Nodelj[bucketsize];
        for (int i = 0; i < bucketsize; i++) {
            hashTableNodes[i] = new Nodelj();
        }

        //找出最大最小值(设置array[0]存数组最大值，array[1]存最小值)，并确定桶的间距
        /*int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }*/

        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        //桶的间距: 因为除法只保留商的原因，需要加1，向上取整
        int bucketgap = (max - min) / bucketsize + 1;
        int bucketNum = 0;
        //哈希数据（哈希之后使用插入排序，对桶内进行排序）
        for (int i : array) {
            bucketNum = (i - min) / bucketgap;
            //桶内插入排序(注意每次需要新建节点)
            Nodelj point = new Nodelj(i);
            //插入链表，注意新建的节点value均为Integer.MIN_VALUE
            if (Integer.MIN_VALUE == hashTableNodes[bucketNum].key) {
                hashTableNodes[bucketNum] = point;
            } else {
                //链表的插入排序
                Nodelj pro = hashTableNodes[bucketNum];
                Nodelj p = pro;
                //此处需要注意 头节点 的问题
                while (p != null && p.key < point.key) {
                    pro = p;
                    p = p.next;
                }
                if(p == pro){
                    point.next = pro;
                    hashTableNodes[bucketNum] = point;
                }else{
                    point.next = pro.next;
                    pro.next = point;
                }
            }
        }
        //整理为数组并返回
        int count = 0;
        for (int i = 0; i < bucketsize; i++) {
            Nodelj p = hashTableNodes[i];
            while (p != null && p.key != Integer.MIN_VALUE) {
                array[count] = p.key;
                p = p.next;
                count++;
            }
        }
    }
}