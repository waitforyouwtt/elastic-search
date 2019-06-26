package com.yidiandian.elasticsearch.mapper;

import com.yidiandian.elasticsearch.entity.Admin;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/25 17:03
 * @Email: 15290810931@163.com
 */
public interface AdminMapper extends ElasticsearchRepository<Admin,String> {

    Admin findAdminByUserName(String userName);

    Admin findAdminByNickName(String nickName);

    Admin findAdminByMobile(String mobile);

    Admin findAdminByUserNameAndPassword(String userName,String password);
}
