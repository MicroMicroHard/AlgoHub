package DataStructure.heapStackQueue.heap;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/12 11:01 PM
 * @author-Email micromicrohard@outlook.com
 * @description 词频统计
 * 实现统计一篇英文文章内每个单词的出现频率，并返回出现频率最高的前10个单词及其出现次数？
 */

public class WordFrequency {

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

    // StatisticsWordFrequency
    public String[] Solution(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        Map<String, Words> statisticsMap = new HashMap<>();
        PriorityQueue queue = new PriorityQueue();
        for (String word : words) {
            // update frequency
            Words w = statisticsMap.getOrDefault(word, null);
            if (w == null) {
                w = new Words(word, 1);
                statisticsMap.put(word, w);
            } else {
                w.frequency++;
                statisticsMap.put(word, w);
            }
            if (queue.QueueRealSize != 0 && queue.peek().frequency > w.frequency) {
                continue;
            }
            queue.offer(w);
        }
        return queue.trans2StringArr();
    }

    static class Words {
        int frequency;
        String word;
        boolean inTheQueue;//是否在队列中，替换contains函数，时间复杂度为O(1)

        public Words(String word, int fre) {
            this.word = word;
            frequency = fre;
        }
    }

    static class PriorityQueue {
        public Words[] queue;
        public int QueueRealSize;
        public int QueueMaxSize = 10;

        public PriorityQueue() {
            this.QueueRealSize = 0;
            this.queue = new Words[10];
        }

        public Words peek() {
            if (this.QueueRealSize == 0) {
                return null;
            }
            return queue[0];
        }

        //出队判空
        public Words poll() {
            if (this.QueueRealSize == 0) {
                return null;
            }
            Words value = queue[0];
            Words x = queue[QueueRealSize - 1];
            QueueRealSize--;
            offer(x);
            return value;
        }

        public void offer(Words value) {
            if (QueueRealSize == QueueMaxSize) {
                // 当堆满了的时候，需要进行更新
                updateQueue(value);
                return;
            }
            value.inTheQueue = true;
            int position = QueueRealSize;
            while (position > 0) {
                int parent = (position - 1) >> 1;
                if (queue[parent].frequency < value.frequency) {
                    break;
                }
                queue[position] = queue[parent];
                position = parent;
            }
            queue[position] = value;
            QueueRealSize++;
        }

        public void updateQueue(Words value) {
            // 如果已经存在与queue，则进行更新
            if (value.inTheQueue) {
                replaceQueueWhenExist(value);
                return;
            }
            // 替换其他值
            queue[0].inTheQueue = false;
            value.inTheQueue = true;
            queue[0] = value;
            replaceQueue(value, 0);
        }

        /*public boolean contains(String word) {
            for (int i = 0; i < QueueRealSize; i++) {
                if (queue[i].word.equals(word)) {
                    return true;
                }
            }
            return false;
        }*/

        public void replaceQueueWhenExist(Words value) {
            for (int i = 0; i < QueueRealSize; i++) {
                if (queue[i].word.equals(value.word)) {
                    queue[i].frequency++;
                }
            }
        }

        public void replaceQueue(Words value, int index) {
            // 左右孩子对比
            int child = 2 * index + 1;
            if (child > QueueMaxSize) {
                return;
            }
            if (child + 1 < QueueMaxSize) {
                child = queue[child].frequency > queue[child + 1].frequency ? child + 1 : child;
            }
            if (queue[child].frequency < value.frequency) {
                swap(value, queue[child]);
                replaceQueue(queue[child], child);
            }
        }

        public void swap(Words a, Words b) {
            int fre = a.frequency;
            String word = a.word;
            a.frequency = b.frequency;
            a.word = b.word;
            b.word = word;
            b.frequency = fre;
        }

        public String[] trans2StringArr() {
            if (QueueRealSize == 0) {
                return null;
            }
            String[] answer = new String[QueueRealSize];
            for (int i = 0; i < QueueRealSize; i++) {
                answer[i] = queue[i].word;
            }
            return answer;
        }
    }
}
