package DesignPattern.single;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-4-22 Time������12:04:39
 * @Email micromicrohard@outlook.com
 * @description
 */
public class InnerClassSingletom implements Singletom {

    private InnerClassSingletom() {
    }

    //inner-class
    public static class SinglePatternHub {
        private static final InnerClassSingletom singlePattern =
                new InnerClassSingletom();
    }

    public static InnerClassSingletom getsSinglePattern() {
        return SinglePatternHub.singlePattern;
    }
}