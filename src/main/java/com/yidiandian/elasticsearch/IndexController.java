package com.yidiandian.elasticsearch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/6 17:11
 * @Email: 15290810931@163.com
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "ok";
    }
}
