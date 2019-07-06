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

/**
 * 手写JDK动态代理
 */
public class ProxyUtilJDK {

    /**
     * 模仿JDk动态代理
     * @param  targetInf 代理接口
     * @param  handler 代理逻辑实现类
     * @return
     */
    public static Object newInstance(Class targetInf, Object handler) {
        //获取代理实现类的接口
        Class handlerClass = handler.getClass().getInterfaces()[0];
        //获取目标对象的所有方法
        Method[] methods = targetInf.getDeclaredMethods();
        //获取目标对象的名称
        String infName = targetInf.getSimpleName();
        //代理实现接口的名称
        String handlerName = handlerClass.getSimpleName();
        String line = "\n";
        String tab = "\t";
        String content = "";
        String packageContent = "package com.wzy.proxy.dynamics_proxy;"+line;
        //需要引入的包
        String importContent = "import "+targetInf.getName()+";"+line
                                + "import java.lang.reflect.Method;"+ line
                                + "import com.wzy.proxy.dynamics_proxy.TestInvocationHandler;"+ line
                                + "import java.lang.Exception;"+ line;
        //类的第一行
        String claszzFirstLineContent = "public class $Proxy implements "+infName+ " {" + line;
        //代理类的属性，也就是代理接口
        String filedContent = tab + "private "+handlerName + " h;"+line;
        //代理类的构造方法
        String constructorContent = tab + "public $Proxy("+ handlerName + " h){" + line
                                    + tab+tab + "this.h = h;"+ line
                                    + tab + "}"+ line;
        //方法
        String methodContent = "";
        for(Method method : methods) {
            String returnType = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class[] args = method.getParameterTypes();
            //方法的参数
            String argsContent = "";
            String classContent = "";
            //方法的参数名称
            String paramsContent = "";
            int i=0;
            for(Class arg : args) {
                String temp = arg.getSimpleName();
                classContent += temp+".class,";
                argsContent += temp + " p"+i+",";
                paramsContent += "p"+i+",";
                i++;
            }
            if(argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(","));
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(","));
                classContent = classContent.substring(0, classContent.lastIndexOf(","));
            }
            methodContent +=  tab+"public "+ returnType + " " + methodName + "( " +  argsContent + ") {" + line
                            + tab + tab + "Method method = null;"+line;
            if(argsContent.length() > 0) {
                methodContent += tab + tab + "Object[] args = new Object[]{"+paramsContent+"};"+line
                                + tab + tab + "Class[] argsClass = new Class[]{"+classContent+"};"+line;
            }
            methodContent += tab + tab + "try {" + line;
            if(argsContent.length() > 0) {
                methodContent += tab + tab + tab + "method = "+infName+".class.getDeclaredMethod(\""+methodName+"\", argsClass);"+line;
            }else {
                methodContent += tab + tab + tab + "method = "+infName+".class.getDeclaredMethod(\""+methodName+"\");"+line;
            }
            methodContent += tab + tab + "} catch (Exception e) {" + line
                            + tab + tab + tab + "e.printStackTrace();" + line
                            + tab + tab + "}" + line;
            if(!returnType.equals("void")) {
                methodContent += tab + tab + "return ("+returnType+")h.invoke(method, args);"+ line
                                + tab + "}";
            }else {
                methodContent += tab + tab + "h.invoke(method, new Object[0]);"+ line
                        + tab + "}";
            }
            methodContent += line;
        }
        content = packageContent + importContent + claszzFirstLineContent + filedContent + constructorContent + methodContent + "}";
        //将代理类的字符串保存至本地磁盘
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
            //从本地磁盘获取文件编译成.class（字节码）文件
            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.wzy.proxy.dynamics_proxy.$Proxy");
            //生成代理对象，并返回
            Constructor constructor = clazz.getConstructor(handlerClass);
            return constructor.newInstance(handler);
        }catch (Exception e) {

        }
        return null;
    }

}
