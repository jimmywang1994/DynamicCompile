package com.ww.jvmClassLoader;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader=new FileSystemClassLoader("c:/myjava");
        FileSystemClassLoader loader2=new FileSystemClassLoader("c:/myjava");
        Class<?> c=loader.loadClass("HelloWorld");
        System.out.println(c);
        System.out.println(c.hashCode());
        Class<?> c2=loader.loadClass("HelloWorld");
        System.out.println(c2);
        System.out.println(c2.hashCode());
        Class<?> c3=loader2.loadClass("HelloWorld");
        Class<?> c4=loader.loadClass("java.lang.String");
        Class<?> c5=loader2.loadClass("com.ww.jvmClassLoader.Demo01");
        System.out.println(c3);
        System.out.println(c3.hashCode());//同一个类被两个不同加载器加载，jvm认为是不同的类
        System.out.println(c3.getClassLoader());
        System.out.println(c4.getClassLoader());//引导类加载器
        System.out.println(c2.getClassLoader());
        System.out.println(c5.getClassLoader());//系统默认类加载器
    }
}
