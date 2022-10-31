package DataStructure.list.listRealize;

import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-07 18:17
 * @author-Email micromicrohard@outlook.com
 * @description 双向链表
 * 1、插入（批量插入、指定位置插入）
 * 2、删除（删除元素、删除指定位置的元素）
 * 3、查找（查找元素、查找指定位置的元素）
 * 4、输出（数组）
 * 5、相等
 * 6、清除
 * @blogURL
 */
public class DuplexLinkedList implements Listlj {

    Nodelj headPoint;
    Nodelj tailPoint;
    int size;
    private static final int error = Integer.MIN_VALUE;

    public DuplexLinkedList() {
        this.headPoint = null;
        this.tailPoint = null;
        this.size = 0;
    }

    @Override
    public boolean insert(boolean headInsert, Nodelj... nodes) {
        return false;
    }

    /**
     * @param HeadTail 头插法或者尾插法(true:头插法，false:尾插法)
     * @param array    输入待插入数据
     * @return
     */
    
    public boolean insert(boolean HeadTail, int... array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int begin = 0;
        if (this.size == 0) {
            Nodelj nodefirst = new Nodelj(array[0]);
            this.headPoint = nodefirst;
            this.tailPoint = nodefirst;
            nodefirst.front = nodefirst;
            nodefirst.next = nodefirst;
            this.size++;
            begin++;
        }
        for (int i = begin; i < array.length; i++) {
            Nodelj node1 = new Nodelj(array[i]);
            node1.front = this.tailPoint;
            node1.next = this.headPoint;
            if (HeadTail) {//头插法
                node1.next.front = node1;
                this.headPoint = node1;
                this.tailPoint.next = node1;
            } else {//尾插法
                node1.front.next = node1;
                this.tailPoint = node1;
                this.headPoint.front = node1;
            }
            this.size++;
        }
        return true;
    }

    @Override
    public boolean insertIndex(int index, Nodelj... nodes) {
        return false;
    }

    @Override
    public boolean insertIndex(int index, int[] nodes) {
        return false;
    }

    @Override
    public void delete(Nodelj node) {
        
    }

    @Override
    public void delete(boolean isDeleteHead) {

    }

    @Override
    public void deleteIndex(int index) {

    }


    @Override
    public int searchValue(int key) {
        return 0;
    }

    @Override
    public int searchValue(Nodelj node) {
        return 0;
    }

    @Override
    public int searchIndex(int index) {
        return 0;
    }

    /**
     * @param index 索引位置
     * @param args  待插入元素
     * @return 插入成功
     */
    
    public boolean insert(int index, int... args) {
        if (index > this.size) {
            return false;
        }
        if (this.size == 0) {
            insert(false, args);
            return true;
        }
        Nodelj cur = this.headPoint;
        Nodelj pre = this.tailPoint;
        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }
        for (int arg : args) {
            Nodelj nodelj = new Nodelj(arg);
            //节点关系
            pre.next = nodelj;
            nodelj.front = pre;
            cur.front = nodelj;
            nodelj.next = cur;
            //node = nodelj;//头插法
            pre = nodelj;//尾插法
            this.size++;
        }
        if (index == 0) {
            this.headPoint = pre;
        }

        return true;
    }

    
    public boolean delete_value(int key) {
        if (this.size == 0) {
            return false;
        }
        if (this.size == 1) {
            if (this.headPoint.key == key) {
                clear();
                return true;
            }
            return false;
        }
        Nodelj nodelj = this.headPoint;
        do {
            if (nodelj.key == key) {
                nodelj.front.next = nodelj.next;
                nodelj.next.front = nodelj.front;
                this.size--;
                return true;
            }
            nodelj = nodelj.next;
        } while (nodelj != this.headPoint);
        return false;
    }

    
    public boolean delete_index(int index) {
        if (index <= this.size) {
            Nodelj nodelj = this.headPoint;
            int count = 0;
            while (count < index) {
                nodelj = nodelj.next;
                count++;
            }
            nodelj.next.front = nodelj.front;
            nodelj.front.next = nodelj.next;
            this.size--;
            return true;
        }
        return false;
    }

    /**
     * @param key 值
     * @return 查找指定元素，返回该元素的索引位置
     */
    
    public int search_value(int key) {
        if (this.size != 0) {
            Nodelj nodelj = this.headPoint;
            int count = 0;
            do {
                if (nodelj.key == key) {
                    return count;
                }
                count++;
                nodelj = nodelj.next;
            } while (nodelj != this.headPoint);
        }
        return -1;
    }

    /**
     * @param index 索引
     * @return 索引值对应的value
     */
    
    public int search_index(int index) {
        if (index > this.size) {
            return error;
        }
        Nodelj nodelj = this.headPoint;
        int count = 0;
        while (count < index) {
            nodelj = nodelj.next;
            count++;
        }
        return nodelj.key;
    }

    
    public int[] toArray() {
        if (this.size == 0) {
            return new int[]{};
        } else {
            int count = 0;
            int[] arr = new int[this.size];
            Nodelj nodelj = this.headPoint;
            do {
                arr[count] = nodelj.key;
                nodelj = nodelj.next;
                count++;
            } while (nodelj != this.headPoint);
            return arr;
        }
    }

    @Override
    public void print() {

    }


    public void clear() {
        this.headPoint = null;
        this.tailPoint = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean listEquals(Listlj l2) {
        return listEquals(this, l2);
    }

    public boolean listEquals(Listlj l3, Listlj l4) {
        DuplexLinkedList l1 = (DuplexLinkedList) l3;
        DuplexLinkedList l2 = (DuplexLinkedList) l4;
        if (l1 == l2) {
            return true;
        }
        if (l1 != null && l2 != null && l1.headPoint.key == l2.headPoint.key) {
            /*Nodelj l1node = l1.headpoint.next;
            Nodelj l2node = l2.headpoint.next;
            while (l1node != l1.headpoint) {
                if (l1node.key != l2node.key) {
                    return false;
                }
                l1node = l1node.next;
                l2node = l2node.next;
            }*/
            return Arrays.equals(l1.toArray(), l2.toArray());
        }
        return false;
    }
}
