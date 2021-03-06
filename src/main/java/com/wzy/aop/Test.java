package com.wzy.aop;

/**
 * @ClassName Test
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 14:53
 **/
public class Test {

    /**
     * AOP:面向切面编程，相对于传统的OOP，AOP就是将OOP中那些与主逻辑无关的横切性问题分离出来
     * （例如：记录日志，访问控制和性能检测），从而达到解耦的目的，使代码的重用性和开发效率提高。
     *     1.通知（Advice）
     * 　　就是你想要的功能，也就是上面说的 安全，事物，日志等。你给先定义好把，然后在想用的地方用一下。
     *     2.连接点（JoinPoint）
     * 　　这个更好解释了，就是spring允许你使用通知的地方，那可真就多了，基本每个方法的前，后（两者都有也行），
     * 或抛出异常时都可以是连接点，spring只支持方法连接点.其他如aspectJ还可以让你在构造器或属性注入时都行，不过那不是咱关注的，只要记住，和方法有关的前前后后（抛出异常），都是连接点。
     *     3.切入点（Pointcut）
     * 　　上面说的连接点的基础上，来定义切入点，你的一个类里，有15个方法，那就有几十个连接点了对把，
     * 但是你并不想在所有方法附近都使用通知（使用叫织入，以后再说），你只想让其中的几个，在调用这几个方法之前，之后或者抛出异常时干点什么，那么就用切点来定义这几个方法，让切点来筛选连接点，选中那几个你想要的方法。
     *     4.切面（Aspect）
     * 　　切面是通知和切入点的结合。现在发现了吧，没连接点什么事情，连接点就是为了让你好理解切点，搞出来的，
     * 明白这个概念就行了。通知说明了干什么和什么时候干（什么时候通过方法名中的before,after，around等就能知道），而切入点说明了在哪干（指定到底是哪个方法），这就是一个完整的切面定义。
     *     5.引入（introduction）
     * 　　允许我们向现有的类添加新方法属性。这不就是把切面（也就是新方法属性：通知定义的）用到目标类中吗
     *     6.目标（target）
     * 　　引入中所提到的目标类，也就是要被通知的对象，也就是真正的业务逻辑，他可以在毫不知情的情况下，被咱们织入切面。
     * 而自己专注于业务本身的逻辑。
     *     7.代理(proxy)
     * 　　怎么实现整套aop机制的，都是通过代理，这个一会给细说。
     *     8.织入(weaving)
     * 　　把切面应用到目标对象来创建新的代理对象的过程
     *
     *
     *
     * execution(modifiers-pattern(作用域 public、private)? ret-type-pattern(返回类型) declaring-type-pattern(类名的全路径)?name-pattern(方法名)(param-pattern(参数))
     *             throws-pattern?(异常))
     * args  属性匹配
     * within  路径匹配
     * annotation 注解匹配
     * this 指当前代理对象，当proxyTargetClass为true时，使用cglib代理，代理对象等于目标对象，为false时，使用JDK代理，代理对象不等同于目标对象
     * target 指目标对象，实际指向的是一个接口
     *
     * JDK动态代理一定要基于聚合（接口）,因为java中类不能多继承，可以实现多个接口,再spring底层JDK代理已经继承了Proxy，
     * 所以不能再继承目标对象，只能实现目标对象,这里的目标对象指的是接口，因为JDK代理只能代理接口，不能代理类
     *@EnableAspectJAutoProxy(proxyTargetClass = true) 使用cglib代理
     *
     * @around 环绕模式，可以在执行目标方法前、后执行业务代码，也可以对需要的方法进行参数上的修改或者封装
     * @DeclareParents(value = "com.wzy.aop.one.*", defaultImpl = IndexDao2.class)引入该路径下的所有实现类，然后去调用IndexDao2的方法实现
     */
}
