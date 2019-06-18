package com.yidiandian.elasticsearch.service;

import com.yidiandian.elasticsearch.entity.Article;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/6 17:16
 * @Email: 15290810931@163.com
 */
public interface ArticleService {
    /**
     * 保存
     * @param article
     * @return
     */
    Article save(Article article);

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteById(String id);
    /**
     * 全部删除
     */
    void deleteAll();
    /**
     * 批量删除
     * @param ids
     */
    int deleteByIds(List<String> ids);
    /**
     * 查询list集合
     * @return
     */
    List<Article> findByTitle(String title);
    /**
     * 根据标题或内容查询
     * @param title
     * @param content
     * @return
     */
    List<Article> findByTitleOrContentLike(String title,String content);

    Article findById(String content);

    Article findByUserId(String userId);

    Article findByContentLike(String content);
}
