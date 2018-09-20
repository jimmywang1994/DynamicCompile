package com.ww.DyanmicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo01 {

    public static void main(String[] args) {
//        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
//        int result=compiler.run(null,null,null,"C:/myjava/HelloWorld.java");
//        System.o ut.println(result==0?"编译成功！":"编译失败");

        try {
            URL[] urls=new URL[]{new URL("file:/"+"c:/myjava/")};
            URLClassLoader classLoader=new URLClassLoader(urls);
            Class c=classLoader.loadClass("HelloWorld");
            Method m=c.getMethod("main",String[].class);
            m.invoke(null,(Object)new String[]{});
        }catch (Exception ex){

        }
    }


}
