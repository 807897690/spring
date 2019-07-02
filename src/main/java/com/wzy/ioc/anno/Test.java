package com.wzy.ioc.anno;

/**
 * @ClassName Test
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 14:42
 **/
public class Test {

    /**
     * 自定义注解的使用
     * @param args
     */
    public static void main(String[] args) {
        Example example = new Example();
        String sql = CommUtil.getQuerySql(example);
        System.out.println(sql);
    }

}
