package com.wzy.ioc.beandependencies;

import com.wzy.ioc.beandependencies.demo.MyImportBeanDefinitionRegistrar;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @ClassName BeanDependenciesConfig
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 11:23
 **/
@Configuration
@ComponentScan("com.wzy.ioc.beandependencies")
@MapperScan("com.wzy.ioc.beandependencies.dao")
@Import(MyImportBeanDefinitionRegistrar.class)
public class BeanDependenciesConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        /**
         * 配置打印日志
         */
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(Log4jImpl.class);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setPassword("940926");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/practice?serverTimezone=GMT%2B8");
        driverManagerDataSource.setUsername("root");
        return driverManagerDataSource;
    }

}
