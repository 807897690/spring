package com.wzy.log;

import java.util.logging.Logger;

/**
 * @author wzy
 * @title: JUL
 * @description: TODO
 * @date 2019/7/16 14:36
 */
public class JUL {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(JUL.class.getName());
        log.info("jul");
    }

}
