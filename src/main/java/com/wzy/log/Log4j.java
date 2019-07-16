package com.wzy.log;

import org.apache.log4j.Logger;

/**
 * @author wzy
 * @title: Log4j
 * @description: TODO
 * @date 2019/7/16 14:54
 */
public class Log4j {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("log4j");
        logger.info("log4j");
    }

}
