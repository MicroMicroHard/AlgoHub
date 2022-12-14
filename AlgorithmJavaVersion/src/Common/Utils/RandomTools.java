package Common.Utils;

import java.util.Random;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-02 23:30
 * @author-Email micromicrohard@outlook.com
 * @description 
 */
public class RandomTools {

    Random random = new Random();

    public String productrandomdomString(){
        //randomd.nextInt(x)��ʾ����[0,x)
        int num = random.nextInt(99)+2;
        return productRandomString(num);
    }

    public static void main(String[] args) {
        String s = "rfSFTdfEes";
        System.out.println(s.toLowerCase().contains("dfE".toLowerCase()));
        System.out.println(s.toLowerCase().contains("dfe".toLowerCase()));
    }

    //������ɸ������ȵ��ַ���
    public String productRandomString(int num){
        /*��asc����,'0'+17='A',��A��+32=��a��
        ���ԣ���0-9��=��0��+[0,9],��A-Z��=��0��+[17,42],��a-z��=��0��+[49,75]*/
        char a = '0';
        int addNum;
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < num; i++) {
            addNum = getEqualNum();
            char c1 = (char) (a + addNum);
            stringBuffer.append(c1);
        }
        return stringBuffer.toString();
    }
    //����һ�������Сд�����ֵ� ��ͬ���� �ַ���:�ַ������ȣ�������2-100
    public String productRandomNumAndString() {

        int num = random.nextInt(99)+2;
        return productRandomNumAndString(num);
    }

    //����һ�������Сд�����ֵ� ���� �ַ���
    public String productRandomNumAndString(int num) {

        String[] alpha = {"A","B","C","D","E","F","G","H","I","J","K",
                "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        //�ַ�������
        StringBuilder stringBuffer = new StringBuilder();
        //mȡֵ1��2��3����ʾѡ�񡰴�д��ĸ������Сд��ĸ���������֡�
        int choice = 0;
        while(num>0){
            choice = random.nextInt(3);
            switch(choice){
                case 0:
                    stringBuffer.append(alpha[random.nextInt(26)]);
                    break;
                case 1:
                    stringBuffer.append(alpha[random.nextInt(26)].toLowerCase());
                    break;
                case 2:
                    stringBuffer.append(random.nextInt(10));
                    break;
                default:
                    break;
            }
            num--;
        }
        //�������ַ���
        return stringBuffer.toString();
    }
    
    //����һ���ȸ��ʵ�[0,9],[17,42],[49,74]֮�����
    public int getEqualNum(){
        int equalNum = random.nextInt(75);
        if((equalNum > 9 && equalNum < 17) || (equalNum > 42 && equalNum < 49)){
            return getEqualNum();
        }
        return equalNum;
    }

}
