package enum1;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ConstantTest {
    public static void main(String args[]) throws Exception {
//        NotUsed o = null; //this class is not used, should not be initialized
//        Child t = new Child(); //initializing sub class, should trigger super class initialization
//        System.out.println((Object)o == (Object)t);
            Class clzz = Class.forName("enum1.Child");
        Field[] declaredFields = clzz.getDeclaredFields();
        Arrays.asList(declaredFields).forEach((var)->{
            System.out.println(var);
        });
//        String s=  Child.s;//initializing sub class's static and super class's static block.
    }
}

/**
 * Super class to demonstrate that Super class is loaded and initialized before Subclass.
 */
class Parent {
    static {
        System.out.println("static block of Super class is initialized");
    }
    {
        System.out.println("non static blocks in super class is initialized");
    }
}

/**
 * Java class which is not used in this program, consequently not loaded by JVM
 */
class NotUsed {
    static {
        System.out.println("NotUsed Class is initialized ");
    }
}

class Child extends Parent {
    public String str;
    public static String s="sss";
    static {
        System.out.println("static block of Sub class is initialized in Java ");
    }
    {
        System.out.println("non static blocks in sub class is initialized");
    }
}
