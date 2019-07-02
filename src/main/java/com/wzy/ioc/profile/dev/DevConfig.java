package com.wzy.ioc.profile.dev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName DevConfig
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 12:06
 **/
@Configuration
@ComponentScan("com.wzy.ioc.profile.dev")
@Profile("dev")
public class DevConfig {
}
