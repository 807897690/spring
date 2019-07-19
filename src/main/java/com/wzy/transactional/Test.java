package com.wzy.transactional;

/**
 * @author wzy
 * @title: Test
 * @description:
 * 事务的四大特点：一致性、原子性、隔离性、持久性
 * select @@tx_isolation; 查询数据库隔离级别Read uncommitted（未提交读）、Read committed（可提交读）、
 * Repeatable read（可重复读）、Serializable（序列化）
 * 传播行为：
 * 1、PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
 * 2、PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。‘
 * 3、PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。
 * 4、PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
 * 5、PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
 * 6、PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
 * 7、PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
 *
 *
 * spring中同一个类中两个方法A和B,都有声明式事务，A为REQUIRED，B为REQUIRES_NEW，A方法内部调用B,外部调用A时，
 * B方法上的事务没有生效，即使B内部抛出异常，也会操作数据库成功
 * 原因：动态代理最终都是要调用原始对象的，而原始对象在去调用方法时，是不会再触发代理了
 * 解决：1、实现ApplicationContextAware，获取ApplicationContext,调用getBean获取代理对象
 * 2、AopContext.currentProxy() 获取代理对象,但是需要配置exposeProxy=true
 * @date 2019/7/19 11:10
 */
public class Test {

    public static void main(String[] args) {
        final DBUtil dbUtil = new DBUtil();
        new Thread(){
            @Override
            public void run() {
                String sql = "update `config` set `desc` = 'desc属性'";
                dbUtil.update(sql);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                String querySql = "select * from config";
                dbUtil.query(querySql);
            }
        }.start();
    }

}
