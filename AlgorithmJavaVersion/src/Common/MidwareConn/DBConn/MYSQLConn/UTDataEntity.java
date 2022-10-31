package Common.MidwareConn.DBConn.MYSQLConn;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/12 7:28 PM
 * @author-Email micromicrohard@outlook.com
 * @description SQL对象实体
 */
public class UTDataEntity {

    public int id;
    public String input;           // 输入
    public String output;          // 输出
    public String className;       // 类名
    public String inputDesc;       // 输入描述
    public String outputDesc;      // 输出描述
    public String class_describe;  // 题目描述
    public String preParamsType;

    public UTDataEntity(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public UTDataEntity(String input, String output, String className) {
        this.input = input;
        this.output = output;
        this.className = className;
    }

    public UTDataEntity(int id, String input, String output, String className) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.className = className;
    }

    public UTDataEntity(int id,
                        String input, String output, String className,
                        String inputDesc, String outputDesc, String class_describe) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.className = className;
        this.inputDesc = inputDesc;
        this.outputDesc = outputDesc;
        this.class_describe = class_describe;
    }

    public UTDataEntity(String input, String output, String className,
                        String inputDesc, String outputDesc, String class_describe) {
        this.input = input;
        this.output = output;
        this.className = className;
        this.inputDesc = inputDesc;
        this.outputDesc = outputDesc;
        this.class_describe = class_describe;
    }

    public void print() {
        System.out.println();
        System.out.println("SQLTestDataEntity: " +
                "id: " + this.id +
                "\n                   input: " + this.input +
                "\n                   output: " + this.output +
                "\n                   className: " + this.className
        );
    }
}
