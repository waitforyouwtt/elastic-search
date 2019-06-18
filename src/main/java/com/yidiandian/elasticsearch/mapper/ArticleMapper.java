package com.yidiandian.elasticsearch.mapper;

import com.yidiandian.elasticsearch.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/6 17:15
 * @Email: 15290810931@163.com
 */
public interface ArticleMapper extends ElasticsearchRepository<Article,String> {

    List<Article> findByTitle(String title);

   // Map<String,String> findByTitleOrContentLike(String title, String content);

    List<Article> findByTitleOrContentLike(String title, String content);

    Optional<Article> findByUserId(String userId);

    Article findByContentLike(String content);

    int deleteByIdIn(List<String> ids);


}
