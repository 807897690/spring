package com.wzy.ioc.beandependencies;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
public class BeanDependenciesConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setPassword("940926");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/practice");
        driverManagerDataSource.setUsername("root");
        return driverManagerDataSource;
    }

}
