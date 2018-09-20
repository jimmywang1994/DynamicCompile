package com.ww.DyanmicCompile;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;

public class Demo2 {
    public static void main(String[] args) throws CannotCompileException {
        ClassPool pool=ClassPool.getDefault();
        CtClass ctClass=pool.makeClass("com.ww.DyanmicCompile.Emp");

        //创建属性
        CtField c1=CtField.make("private int empNo;",ctClass);
        CtField c2=CtField.make("private String empName;",ctClass);
        ctClass.addField(c1);
        ctClass.addField(c2);
    }
}
