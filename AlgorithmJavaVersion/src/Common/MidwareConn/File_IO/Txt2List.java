package Common.MidwareConn.File_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-10-22 16:03
 * @author-Email micromicrohard@outlook.com
 * @description read txt to list
 */
public class Txt2List {

    ArrayList<String> list;
    int rowNum;

    public ArrayList<String> ReadTxt2List(String path) {
        rowNum = 1;
        list = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            while (null != (strLine = bufferedReader.readLine())) {
                System.out.println("��[" + rowNum + "]������:[" + strLine + "]");
                /*strLine = strLine.replace("ϵͳ","");
                strLine = strLine.replace("��Ŀ","");
                strLine = strLine.replace("����","");
                strLine = strLine.replace("����","");
                strLine = strLine.replace("��Ϣ","");
                strLine = strLine.replace("ƽ̨","");*/
                list.add(strLine);
                rowNum++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
