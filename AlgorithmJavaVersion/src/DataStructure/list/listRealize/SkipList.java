package DataStructure.list.listRealize;

import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;

import java.util.Random;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-7-25 11:59:31
 * @author-Email micromicrohard@outlook.com
 * @description 跳表
 * 支持：
 * <p>
 * 1、插入（批量插入）
 * 2、删除（删除元素）
 * 3、查找（查找元素、查找指定位置的元素）
 * 4、输出（数组）
 * 5、相等
 * 6、清除
 */
public class SkipList implements Listlj {

    //首尾指针
    public Nodelj head, tail;
    //链表的层高
    public int SkipListlevel;
    //链表的节点个数，最底层的那一层（实际插入的元素个数）
    public int SkipListNum;
    private static final int HEAD_KEY = Integer.MIN_VALUE;
    private static final int TAIL_KEY = Integer.MAX_VALUE;
    private static final int error = Integer.MIN_VALUE;

    public SkipList() {
        this.head = initial();
        this.tail = head.next;
        this.SkipListlevel = 1;
        this.SkipListNum = 0;
    }

    @Override
    public boolean insert(boolean headInsert, Nodelj... nodes) {
        return false;
    }

    /**
     * 经过实验证明：查找 耗时 比 插入 更加耗时。
     * 层数越高，整个数据备份越多，越臃肿，但是查找快
     * 层数越低，整个数据备份越少，      但是插入和删除快
     * 综合考虑，建议层数高
     */
    
    public boolean insert(boolean HeadTail, int... args) {
        if (args == null || args.length == 0) {
            return false;
        }
        for (int arg : args) {
            Nodelj insertKey;
            Nodelj fathernode = null;
            if (this.SkipListNum > (2 << this.SkipListlevel - 1)) {
                relever();
                insertKey = this.head;
            } else {
                int levelNum = randomLevel();
                insertKey = this.head;
                for (int j = 0; j < levelNum; j++) {
                    insertKey = insertKey.down;
                }
            }
            //循环在每一层都创建该值
            while (insertKey != null) {
                while (insertKey.next.key < arg) {
                    insertKey = insertKey.next;
                }
                //此处的Node需要在每一层都建立一个
                Nodelj node = new Nodelj(arg);
                if (fathernode != null) {
                    fathernode.down = node;
                }
                node.next = insertKey.next;
                insertKey.next = node;
                insertKey = insertKey.down;
                fathernode = node;
            }
            SkipListNum++;
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

    //跳表没有这个功能
    
    public boolean insert(int index, int... args) {
        return insert(true, args);
    }

    
    public boolean delete_value(int key) {
        if (-1 == search_value(key)) {
            return false;
        }
        Nodelj point = this.head;
        Nodelj prepoint = point;
        while (point.key != key) {
            while (point.next.key <= key) {
                prepoint = point;
                point = point.next;
            }
            if (point.key == key) {
                break;
            }
            point = point.down;
            prepoint = prepoint.down;
            if (point.equals(prepoint)) {
                continue;
            }
            while (prepoint.next != point) {
                prepoint = prepoint.next;
            }
        }
        //开始清除工作
        while (prepoint != null) {
            point = point.down;
            prepoint.next = prepoint.next.next;
            prepoint = prepoint.down;
            //prepoint 向 point 靠近
            while (prepoint != null && prepoint.next != point) {
                prepoint = prepoint.next;
            }
        }
        this.SkipListNum--;
        /**
         * 操作：降层
         * 注意：每次删除操作后，进行降层操作，
         *      注意到降层操作是一个循环过程，而不是一个判断过程
         *      当连续层级关系是仅有一个元素的时候，需要进行连续降级
         */
        while (this.head.next == this.tail && this.head.down != null) {
            head = head.down;
            tail = tail.down;
            this.SkipListlevel--;
        }
        return true;
    }

    //跳表没有这个功能
    
    public boolean delete_index(int index) {
        return false;
    }

    
    public int search_value(int key) {
        Nodelj point = this.head;
        int index = 0;
        while (point != null) {
            while (point.next.key <= key) {
                point = point.next;
                index++;
            }
            if (point.key == key) {
                return index;
            }
            point = point.down;
        }
        return -1;
    }

    
    public int search_index(int index) {
        if (index < this.SkipListNum) {
            Nodelj p = this.head;
            while (p.down != null) {
                p = p.down;
            }
            int count = 0;//第一个首节点是标记为，其值是HEAD_KEY = Integer.MIN_VALUE
            while (count <= index) {
                p = p.next;
                count++;
            }
            return p.key;
        }
        return this.error;
    }

    
    public int[] toArray() {
        Nodelj headpoint = this.head;
        while (headpoint.down != null) {
            headpoint = headpoint.down;
        }
        headpoint = headpoint.next;
        int[] arr = new int[this.SkipListNum];
        int count = 0;
        while (headpoint.key != TAIL_KEY) {
            arr[count] = headpoint.key;
            headpoint = headpoint.next;
            count++;//总是 会忘记类似的一些自加操作
        }
        return arr;
    }

    //输出结构
    public void print() {
        Nodelj point;
        Nodelj headpoint = this.head;
        while (headpoint != null) {
            point = headpoint;
            while (point.key != TAIL_KEY) {
                if (point.key != HEAD_KEY) {
                    System.out.print(point.key + "-");
                }
                point = point.next;
            }
            System.out.println();
            headpoint = headpoint.down;
        }
    }

    
    public void clear() {
        this.head = initial();
        this.tail = head.next;
        this.SkipListlevel = 1;
        this.SkipListNum = 0;
    }

    @Override
    public int size() {
        return 0;
    }


    public boolean listEquals(Listlj listlj) {
        return listEquals(this, listlj);
    }

    
    public boolean listEquals(Listlj l1, Listlj l2) {
        SkipList l3 = (SkipList) l1;
        SkipList l4 = (SkipList) l2;
        if (l3 == l4) {
            return true;
        }
        if (l3 != null && l4 != null &&
                l3.SkipListNum == l4.SkipListNum && l3.SkipListlevel == l4.SkipListlevel) {
            /*boolean flag = Arrays.equals(l3.toarray(), l4.toarray());
            return flag;*/
            Nodelj p1 = l3.head;
            Nodelj p2 = l4.head;
            while (p1.down != null) {
                p1 = p1.down;
                p2 = p2.down;
            }
            while (p1.next != null && p1.key == p2.key) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1.next == null;
        }
        return false;
    }

    public Nodelj initial() {
        Nodelj phead = new Nodelj();
        Nodelj ptail = new Nodelj();
        phead.key = HEAD_KEY;
        ptail.key = TAIL_KEY;
        phead.next = ptail;
        return phead;
    }

    //新增加一层
    private void relever() {
        Nodelj phead = initial();
        phead.down = this.head;
        phead.next.down = this.tail;
        head = phead;
        tail = phead.next;
        SkipListlevel++;
    }

    private int randomLevel() {
        Random r = new Random();
        return r.nextInt(SkipListlevel);
    }

}