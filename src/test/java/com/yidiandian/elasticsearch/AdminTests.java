package com.yidiandian.elasticsearch;

import com.yidiandian.elasticsearch.entity.Admin;
import com.yidiandian.elasticsearch.entity.Article;
import com.yidiandian.elasticsearch.service.AdminService;
import com.yidiandian.elasticsearch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class AdminTests extends ElasticSearchApplicationTests{

	@Autowired
	AdminService adminService;
	@Test
	public void save() {
		doInsert();
	}


	@Test
	public void findAdmin(){

		Admin admin = new Admin();
		admin.setUserName("张杰");
		Admin queryByName = adminService.findAdmin(admin,1);
	    log.info("根据name 查询用户:{}",queryByName);
	    admin.setPassword("12345");
	    Admin queryNameAndPwd = adminService.findAdmin(admin,2);
		log.info("根据name,password 查询用户 :{}",queryNameAndPwd);
		admin.setNickName("小胖子凹凸曼");
		Admin queryNickNameAndPwd = adminService.findAdmin(admin,3);
		log.info("根据NickName,password 查询用户 :{}",queryNickNameAndPwd);
		admin.setMobile("17621007255");
		Admin queryMobileAndPwd = adminService.findAdmin(admin,4);
		log.info("根据name,password 查询用户 :{}",queryMobileAndPwd);
	}

	private void doInsert(){
		Admin admin = new Admin("冷小熙","高冷小姐姐","12345","17621007255","北京");
		Admin save = adminService.save(admin);

		Admin admin1 = new Admin("张杰","杰哥","12345","15290810931","沈丘");
		Admin save1 = adminService.save(admin1);

		Admin admin2 = new Admin("张洁","小胖子凹凸曼","12345","15738200244","北京");
		Admin save2 = adminService.save(admin2);

		log.info("保存的结果：{}，{}，{}",save,save1,save2);
	}

}
