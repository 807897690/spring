package com.wzy.ioc.beandependencies.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author wzy
 * @title: ConfigDao
 * @description: TODO
 * @date 2019/7/17 15:08
 */
@CacheNamespace
public interface ConfigDao1 {

    @Update("update config set code = 'newCode' where code = 'code'")
    int update();

}
