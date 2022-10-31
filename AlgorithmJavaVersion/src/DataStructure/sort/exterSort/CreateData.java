package DataStructure.sort.exterSort;

import org.junit.Test;
import java.io.*;
import java.util.Random;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/6
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description
 */
public class CreateData {

    Random r = new Random();
    FileOutputStream outSTr = null;
    BufferedOutputStream Buff = null;
    OutputStreamWriter osw = null;
    int u = 0;
    String firepath = "./javaVersion/DataStructure/sort/exterSort/exterSortData1.txt";

    @Test
    public void createRandomTxt(){
        try {
            File file = new File(firepath);
            if (!file.exists()) {
                file.createNewFile();
            }
            //使用true，即进行append file
            //FileWriter fileWritter = new FileWriter(file.getName(), true);

            outSTr = new FileOutputStream(file);
            osw =new OutputStreamWriter(outSTr,"utf-8");
            BufferedWriter writer = new BufferedWriter(osw);
            Buff = new BufferedOutputStream(outSTr);
            for (int i = 0; i < 1_000; i++) {
                u = r.nextInt();
                writer.write(u+"\n");
                //Buff.write(u);
            }
            //fileWritter.close();
            writer.flush();
            writer.close();
            System.out.println("finish");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
