package com.yidiandian.elasticsearch.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/25 17:15
 * @Email: 15290810931@163.com
 */
public enum UserQueryEnum {

    QUERY_USERNAME(0,"根据用户名查询用户信息"),
    QUERY_USERNAME_PASSWORD(1,"根据用户名和密码查询用户信息"),
    QUERY_NICKNAME_PASSWORD(2,"根据用户昵称和密码查询用户信息"),
    QUERY_MOBILE_PASSWORD(3,"根据用户手机号和密码查询用户信息");

    private Integer code;
    private String msg;

    UserQueryEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
