package com.ww.jvmClassLoader;

import java.io.*;
import java.net.URL;

public class NetSystemClassLoader extends ClassLoader {
    private String rootUrl = "c:/myjava";

    public NetSystemClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String s) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(s);
        //先检查有没有加载过这个类，如果加载过，则直接返回加载好的类。如果没有，则加载新的类
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(s);
            } catch (Exception ex) {

            }
            if (c != null) {
                return c;
            } else {
                byte[] classData = getclassData(s);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(s, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getclassData(String s) {
        String path = rootUrl + "/" + s.replace(".", "/") + ".class";
        InputStream is = null;
        ByteArrayOutputStream byos = new ByteArrayOutputStream();
        try {
            URL url = new URL(path);
            is = url.openStream();
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = is.read(buffer)) != -1) {
                byos.write(buffer, 0, length);
            }
            return byos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                byos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
