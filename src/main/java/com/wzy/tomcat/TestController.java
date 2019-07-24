package com.wzy.tomcat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzy
 * @title: TestController
 * @description: TODO
 * @date 2019/7/24 21:44
 */
@Controller
public class TestController {

    @RequestMapping("/app/test.do")
    @ResponseBody
    public Object test() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("key", "value");
        return result;

    }


}
