package com.ww.jvmClassLoader;

public class Demo01 {
    static{
        System.out.println("静态初始化demo01");
    }
    public static void main(String[] args) {
        System.out.println("Demo1的Main方法");
//       / A a=new A();
//        System.out.println("A.width="+A.width);
//        A a2=new A();
        try {
            Class.forName("com.ww.jvmClassLoader.A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(B.width);
    }
}
class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}
class A extends A_Father{
    public static int width=100;
    static {
        System.out.println("静态初始化A");
        width=300;
        System.out.println(A.MAX);
    }
    public A(){
        System.out.println("创建A的对象");
    }
}

class A_Father{
    public static final int MAX=200;
    static {
        System.out.println("静态初始化A父类");
    }
}
