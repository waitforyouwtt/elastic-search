package com.yidiandian.elasticsearch.service.impl;

import com.yidiandian.elasticsearch.entity.Article;
import com.yidiandian.elasticsearch.mapper.ArticleMapper;
import com.yidiandian.elasticsearch.service.ArticleService;
import com.yidiandian.elasticsearch.utils.GenerateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/6 17:17
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article save(Article article) {
        article.setId(GenerateUtil.autoCode(6));
        return articleMapper.save(article);
    }

    @Override
    public void deleteById(String id) {
        articleMapper.deleteById(id);
    }

    @Override
    public void deleteAll() {
        articleMapper.deleteAll();
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return articleMapper.deleteByIdIn(ids);
    }

    @Override
    public List<Article> findByTitle(String title) {
        List<Article> result = articleMapper.findByTitle(title);
        return result;
    }

    @Override
    public List<Article> findByTitleOrContentLike(String title, String content) {
        List<Article> result = articleMapper.findByTitleOrContentLike(title, content);
        return result;
    }

    @Override
    public Article findById(String id) {
        Optional<Article> optional = articleMapper.findById(id);
        if (! optional.isPresent()){
            return null;
        }
        return optional.get();
    }

    @Override
    public Article findByUserId(String userId) {
        Optional<Article> optional = articleMapper.findByUserId(userId);
        if (! optional.isPresent()){
            return null;
        }
        return optional.get();
    }

    @Override
    public Article findByContentLike(String content) {
        return articleMapper.findByContentLike(content);
    }
}
