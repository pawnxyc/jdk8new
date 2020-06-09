package enum1;
import lombok.ToString;

import java.lang.Enum;
import java.util.Arrays;
import java.util.PrimitiveIterator;
//类加载器有三个 bootstraploader>extention>appclass.
//默认遵守双亲委派原则，优先让启动加载器加载所有的类，保证类的加载过程只有一次。
//类加载器加载的三种方式。执行main方法，class.forname(会执行static{})，classloader.load(不执行static{})
public class TestEnum {
    public static void main(String[] args) {
        Score[] values = Score.values();
//        Arrays.asList(values).forEach(var->{
//            System.out.println(var.name() + "   =======   " + var.ordinal());
//        });
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        System.out.println(contextClassLoader.getParent());
        System.out.println(contextClassLoader.getParent().getParent());
        Score s = Score.getScore(100);
        System.out.println(s);


    }
}

enum Score {
//    枚举类的元素就是枚举类的实列对象，
//    枚举的类会默认继承Enum,所以不能再继承别的类
//    当只有一个枚举元素的时候，也是单列模式（私有构造器，对外提供public static 方法）
//    因为枚举的构造器是私有的，所以不能被继承（类实例化过程，先执行父类的构造方法）
//    枚举中可以有抽象方法，因为抽象类必须被继承
    BEST(100,"满分"),
    GOOD(80,"优秀"),
    OK(60,"及格"),
    LAST(0,"零分"),
    UN_KNOWN(-1,"分数异常");


    int score;
    String privoty;

    @Override
    public String toString() {
        return this.privoty + "====" + this.score;
    }

    private Score(int score, String p){
        this.score = score;
        this.privoty = p;
    }
    public static Score getScore(int score){
        Score[] values = Score.values();
        for (Score v : values){
            if(v.score == score){
                return v;
            }
        }

        return UN_KNOWN;
    }
}
