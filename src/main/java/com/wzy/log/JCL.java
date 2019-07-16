package com.wzy.log;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wzy
 * @title: JCL
 * @description:
 * 如果使用jcl来记录日志, 在没有log4j的依赖情况下, 是用jul
 * 如果有了log4j则使用log4j
 * @date 2019/7/16 14:35
 */
public class JCL {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(JCL.class.getName());
        log.info("jcl");
    }

}
