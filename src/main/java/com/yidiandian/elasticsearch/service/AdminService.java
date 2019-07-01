package com.yidiandian.elasticsearch.service;

import com.yidiandian.elasticsearch.entity.Admin;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/25 17:06
 * @Email: 15290810931@163.com
 */
public interface AdminService {
    /**
     * 添加
     * @param admin
     * @return
     */
    Admin save(Admin admin);
    /**
     * 查询用户信息
     * @param admin 查询参数
     * @param queryType 查询类型
     * @return
     */
    Admin findAdmin(Admin admin,Integer queryType) ;

    void deleteById(String id);
}
