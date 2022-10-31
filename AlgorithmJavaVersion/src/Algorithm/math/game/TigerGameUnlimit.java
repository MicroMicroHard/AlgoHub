package Algorithm.math.game;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/6
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 游戏
 */
public class TigerGameUnlimit {

    //无限版
    public static void main(String[] args) {
        Tiger_Game_Utils t = new Tiger_Game_Utils();
        t.flag__limitless = true;
        t.putmoney();
        t.input();
    }
}
