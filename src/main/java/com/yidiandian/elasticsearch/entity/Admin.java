package com.yidiandian.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/25 17:00
 * @Email: 15290810931@163.com
 */
@Document(indexName = "tensquare",type = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    private String id;

    private String userId;

    private String userName;

    private String nickName;

    private String password;

    private String mobile;

    private String address;

    private String gender;

    public Admin(String userName, String nickName, String password, String mobile, String address) {
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
    }

}
