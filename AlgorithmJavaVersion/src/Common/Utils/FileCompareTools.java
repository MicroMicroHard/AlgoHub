package Common.Utils;

import Algorithm.dynamic.lcs.LCS_4compare;
import Common.MidwareConn.File_IO.Txt2List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-10-22 16:32
 * @author-Email micromicrohard@outlook.com
 * @description 文件名匹配
 */
public class FileCompareTools {

    LCS_4compare lcsc = new LCS_4compare();
    HashMap<String, ArrayList<String>> hashmap = new HashMap<>();

    //compare source string and target string,
    // similarity means how many same character in the two string
    public void compareComponent(String source, String target, int similarity) {

        Txt2List rt = new Txt2List();
        ArrayList<String> list1 = rt.ReadTxt2List(source);
        ArrayList<String> list2 = rt.ReadTxt2List(target);

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                lcsc.Lcsforcompare((String) list1.get(i), (String) list2.get(j));
                if (lcsc.getCompareLength() >= similarity) {
                    ArrayList<String> list;
                    if (hashmap.containsKey(list1.get(i))) {
                        list = hashmap.get(list1.get(i));
                    } else {
                        list = new ArrayList<>();
                    }
                    list.add(String.valueOf(lcsc.getCompareLength()) + list2.get(j));
                    hashmap.put((String) list1.get(i), list);
                }
            }
            System.out.println("--------------" + i + "------------------");
        }
    }

    public void print() {
        Set<String> keys = hashmap.keySet();
        int totalnum = 0;
        for (String s : keys) {
            System.out.println(s + "=======:");
            ArrayList list = hashmap.get(s);
            String[] compareStorage = selectionSort(list);
            for (String s1 : compareStorage) {
                System.out.println(s1 + "<---->");
            }
            totalnum++;
            System.out.println("------------------------------------");
        }
        System.out.println("totalnum:" + totalnum);
    }

    public void compareFile(String source, String target, int similarity) {
        compareComponent(source, target, 3);
        print();
    }

    public String[] selectionSort(ArrayList<String> list) {

        int length = list.size();
        String[] compareStorage = new String[length];

        int count = 0;
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            compareStorage[count++] = it.next();
        }

        int flag;
        //???????0??n-1
        for (int i = 0; i < length - 1; i++) {
            //??????????????
            flag = i;
            int targetStringNum = Integer.parseInt(String.valueOf(compareStorage[i].charAt(0)));
            //????????????????????????????????????
            for (int j = i + 1; j <= length - 1; j++) {
                int commpStringNum = Integer.parseInt(String.valueOf(compareStorage[j].charAt(0)));
                if (commpStringNum > targetStringNum) {
                    flag = j;
                    targetStringNum = commpStringNum;
                }
            }
            //??????
            String temp = compareStorage[i];
            compareStorage[i] = compareStorage[flag];
            compareStorage[flag] = temp;
        }
        return compareStorage;
    }

    public static void main(String[] args) {
        String filepath1 = "C:\\Users\\Administrator\\Desktop\\1\\1.txt";
        String filepath2 = "C:\\Users\\Administrator\\Desktop\\1\\3.txt";
        FileCompareTools cf = new FileCompareTools();
        cf.compareComponent(filepath1, filepath2, 3);
        cf.print();
    }
}
