package com.wzy.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        clientService.test();
        System.out.println(clientService.getClass().getName());
        AccountService accountService = context.getBean(AccountService.class);
        accountService.test();
        System.out.println(accountService.getClass().getName());
    }

}
