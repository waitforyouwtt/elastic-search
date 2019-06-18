package com.yidiandian.elasticsearch.controller;

import com.yidiandian.elasticsearch.entity.Article;
import com.yidiandian.elasticsearch.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/6 17:44
 * @Email: 15290810931@163.com
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @PostMapping("/save")
    public String save(Article params){
        Article result = articleService.save(params);
        return result.getId();
    }

    @GetMapping("/findByTitle")
    public List<Article> findByTitle(@RequestParam("title") String title){
        return articleService.findByTitle(title);
    }
}
