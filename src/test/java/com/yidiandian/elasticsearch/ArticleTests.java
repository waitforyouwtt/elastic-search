package com.yidiandian.elasticsearch;

import com.yidiandian.elasticsearch.entity.Article;
import com.yidiandian.elasticsearch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ArticleTests extends ElasticSearchApplicationTests{

	@Autowired
	ArticleService articleService;
	@Test
	public void save() {
		doInsert();
	}

	@Test
	public void deleteById() {
		articleService.deleteById("");
	}
	@Test
	public void deleteAll() {
		articleService.deleteAll();
	}

	@Test
	public void findByTitle(){
		String title = "世间一切皆美";
		List<Article> result = articleService.findByTitle(title);
	    log.info("得到的结果:{}",result);
	}

	@Test
	public void findByTitleOrContentLike(){
		String title = "";
		/*String content = "略尽千山皆不是，空回首，挽不住";*/
		String content = "春水初生";
		List<Article> result = articleService.findByTitleOrContentLike(title,content);
		log.info("得到的结果:{}",result);
	}

	@Test
	public void findById(){
		String id = "h5AhOG";
		Article result = articleService.findByUserId(id);
		log.info("得到的结果:{}",result);
	}

	@Test
	public void findByContentLike(){
		String content = "仿若花开";
		Article result = articleService.findByContentLike(content);
		log.info("得到的结果:{}",result);
	}

	private void doInsert(){
		Article article = new Article();
		//专栏ID
		article.setColumnId("001");
		//用户ID
		article.setUserId("001");
		//文章标题
		article.setTitle("冯唐");
		//文章内容
		article.setContent("春水初生, 春林初盛, 春风十里，不如你");
		//文章封面
		article.setImage("www.baidu.com");
		//发布日期
		article.setCreateTime(new Date());
		//修改日期
		article.setUpdateTime(new Date());
		//是否公开
		article.setIsPublic("1");
		//是否置顶
		article.setIsTop("1");
		//浏览量
		article.setVisits(1);
		//点赞量
		article.setThumbup(0);
		//评论数
		article.setComment(0);
		//审核状态
		article.setState("0");
		//所属频道
		article.setChannelId(577);
		//链接
		article.setUrl("www.baidu.com");
		//文章类型
		article.setType("情感");
		Article result = articleService.save(article);
		log.info("得到的结果:{}",result);

		Article article1 = new Article();
		//专栏ID
		article1.setColumnId("002");
		//用户ID
		article1.setUserId("002");
		//文章标题
		article1.setTitle("万种风情，不敌你回眸一笑");
		//文章内容
		article1.setContent("眸光流转，仿若花开");
		//文章封面
		article1.setImage("www.baidu.com");
		//发布日期
		article1.setCreateTime(new Date());
		//修改日期
		article1.setUpdateTime(new Date());
		//是否公开
		article.setIsPublic("1");
		//是否置顶
		article1.setIsTop("1");
		//浏览量
		article1.setVisits(1);
		//点赞量
		article1.setThumbup(0);
		//评论数
		article1.setComment(0);
		//审核状态
		article1.setState("0");
		//所属频道
		article1.setChannelId(577);
		//链接
		article1.setUrl("www.baidu.com");
		//文章类型
		article1.setType("情感");
		Article result1 = articleService.save(article1);
		log.info("得到的结果:{}",result1);


		Article article2 = new Article();
		//专栏ID
		article2.setColumnId("003");
		//用户ID
		article2.setUserId("003");
		//文章标题
		article2.setTitle("世间一切皆美");
		//文章内容
		article2.setContent("世间一切皆美 你不是，中药很苦，却也是");
		//文章封面
		article2.setImage("www.baidu.com");
		//发布日期
		article2.setCreateTime(new Date());
		//修改日期
		article2.setUpdateTime(new Date());
		//是否公开
		article2.setIsPublic("1");
		//是否置顶
		article2.setIsTop("1");
		//浏览量
		article2.setVisits(1);
		//点赞量
		article2.setThumbup(0);
		//评论数
		article2.setComment(0);
		//审核状态
		article2.setState("0");
		//所属频道
		article2.setChannelId(577);
		//链接
		article2.setUrl("www.baidu.com");
		//文章类型
		article2.setType("情感");
		Article result2 = articleService.save(article2);
		log.info("得到的结果:{}",result2);

		Article article3 = new Article();
		//专栏ID
		article3.setColumnId("004");
		//用户ID
		article3.setUserId("004");
		//文章标题
		article3.setTitle("乔欣");
		//文章内容
		article3.setContent("世界就像一个巨大的夹娃娃机，隔着玻璃，我只想得到你");
		//文章封面
		article3.setImage("www.baidu.com");
		//发布日期
		article3.setCreateTime(new Date());
		//修改日期
		article3.setUpdateTime(new Date());
		//是否公开
		article3.setIsPublic("1");
		//是否置顶
		article3.setIsTop("1");
		//浏览量
		article3.setVisits(1);
		//点赞量
		article3.setThumbup(0);
		//评论数
		article3.setComment(0);
		//审核状态
		article3.setState("0");
		//所属频道
		article3.setChannelId(577);
		//链接
		article3.setUrl("www.baidu.com");
		//文章类型
		article3.setType("情感");
		Article result3 = articleService.save(article3);
		log.info("得到的结果:{}",result3);

		Article article4 = new Article();
		//专栏ID
		article4.setColumnId("005");
		//用户ID
		article4.setUserId("005");
		//文章标题
		article4.setTitle("你的温柔");
		//文章内容
		article4.setContent("你的温柔就像涂了蜂蜜的匕首，在我最没防备的时刻，悄无声息的捅进了我的胸口");
		//文章封面
		article4.setImage("www.baidu.com");
		//发布日期
		article4.setCreateTime(new Date());
		//修改日期
		article4.setUpdateTime(new Date());
		//是否公开
		article4.setIsPublic("1");
		//是否置顶
		article4.setIsTop("1");
		//浏览量
		article4.setVisits(1);
		//点赞量
		article4.setThumbup(0);
		//评论数
		article4.setComment(0);
		//审核状态
		article4.setState("0");
		//所属频道
		article4.setChannelId(577);
		//链接
		article4.setUrl("www.baidu.com");
		//文章类型
		article4.setType("情感");
		Article result4 = articleService.save(article4);
		log.info("得到的结果:{}",result4);
	}

}
