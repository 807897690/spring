package com.wzy.springioc;

/**
 * @author wzy
 * @title: UserService
 * @description: TODO
 * @date 2019/7/7 12:30
 */
public class UserService {

    private UserDao dao;

//    public UserService(UserDao dao) {
//        this.dao = dao;
//    }

    public void test() {
        System.out.println("test");
        dao.test();
    }

}
