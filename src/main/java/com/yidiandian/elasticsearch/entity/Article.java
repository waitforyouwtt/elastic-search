package com.yidiandian.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2019/5/28 10:31
 * 文章表
 */
@Document(indexName = "tensquare",type = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private String id;
    //专栏ID
    private String columnId;
    //用户ID
    private String userId;
    //文章标题
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;
    //文章内容
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;
    //文章封面
    private String image;
    //发布日期
/*    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)*/
   /* @JsonFormat(pattern = "yyyy-MM-dd\'T\'HH:mm:ss")*/
    //private LocalDateTime createTime;
    //修改日期
/*    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)*/
    /*@JsonFormat(pattern = "yyyy-MM-dd\'T\'HH:mm:ss")*/
    //private LocalDateTime updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    //是否公开
    private String isPublic;
    //是否置顶
    private String isTop;
    //浏览量
    private Integer visits;
    //点赞量
    private Integer thumbup;
    //评论数
    private Integer comment;
    //审核状态
    private String state;
    //所属频道
    private Integer channelId;
    //链接
    private String url;
    //文章类型
    private String type;
}
