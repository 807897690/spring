package com.wzy.proxy.dynamics_proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {

    /**
     * 动态生成一个类
     * @return
     */
    public static Object newInstance(Object target) {
        Object proxy = null;
        Class targetInf = target.getClass().getInterfaces()[0];
        Method[] methods = targetInf.getDeclaredMethods();
        String infName = targetInf.getSimpleName();
        String line = "\n";
        String tab = "\t";
        String content = "";
        String packageContent = "package com.wzy.proxy.dynamics_proxy;"+line;
        String importContent = "import "+targetInf.getName()+";"+line;
        //类的第一行
        String claszzFirstLineContent = "public class $Proxy implements "+infName+ " {" + line;
        String filedContent = tab + "private "+infName + " target;"+line;
        String constructorContent = tab + "public $Proxy("+ infName + " target){" + line
                                    + tab+tab + "this.target = target;"+ line
                                    + tab + "}"+ line;
        //方法
        String methodContent = "";
        for(Method method : methods) {
            String returnType = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class[] args = method.getParameterTypes();
            //方法的参数
            String argsContent = "";
            //方法的参数名称
            String paramsContent = "";
            int i=0;
            for(Class arg : args) {
                String temp = arg.getSimpleName();
                argsContent += temp + " p"+i+",";
                paramsContent += "p"+i+",";
                i++;
            }
            if(argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(","));
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(","));
            }
            methodContent +=  tab+"public "+ returnType + " " + methodName + "( " +  argsContent + ") {" + line
                            + tab + tab + "System.out.println(\"log\");"+line;
            if(returnType.equals("void")) {
                methodContent += tab + tab + "target." + methodName + "(" + paramsContent + ");" + line
                        + tab + "}" + line;
            }else {
                methodContent += tab + tab + "return target." + methodName + "(" + paramsContent + ");" + line
                        + tab + "}" + line;
            }
        }
        content = packageContent + importContent + claszzFirstLineContent + filedContent + constructorContent + methodContent + "}";
        String dirctory = "D:\\com\\wzy\\proxy\\dynamics_proxy";
        String fileName = "$Proxy.java";
        File file = new File(dirctory, fileName);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
            t.call();
            fileManager.close();
            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.wzy.proxy.dynamics_proxy.$Proxy");
            Constructor constructor = clazz.getConstructor(targetInf);
            proxy = constructor.newInstance(target);
        }catch (Exception e) {

        }
        return proxy;
    }

}
