package com.wzy.ioc.profile.pro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName ProConfig
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 12:07
 **/
@Configuration
@ComponentScan("com.wzy.ioc.profile.pro")
@Profile("pro")
public class ProConfig {
}
