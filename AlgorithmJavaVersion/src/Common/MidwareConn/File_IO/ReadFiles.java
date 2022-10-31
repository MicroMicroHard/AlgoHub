package Common.MidwareConn.File_IO;

import Common.Utils.StringTools;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/4/10 18:23
 * @author—Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */

public class ReadFiles {

    public static StringTools strTools = new StringTools();

    @Test
    public void TestGetFileContextList() {
        String sourceFile = System.getProperty("user.dir") + "/src/测试情况说明_UTREADME.md";
        List<String> list = ReadFiles.GetFileContextList(sourceFile);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static List<String> GetFileContextList(String FileURL) {
        ArrayList<String> list = new ArrayList<>();
        try {
            File file = new File(FileURL);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            while (null != (strLine = bufferedReader.readLine())) {
                list.add(strLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param URL    文件路径
     * @param symbol 根据 读取标识 获取该行数据
     * @return
     */
    public static List<int[][]> GetIntMatrixList(String URL, String symbol) {

        ArrayList<int[][]> list = new ArrayList<>();
        try {
            File file = new File(URL);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            while (null != (strLine = bufferedReader.readLine())) {
                if (strLine.contains(symbol)) {
                    list.add(strTools.RecognizeIntMatrix(strLine));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
