package com.yidiandian.elasticsearch.enums;

/**
 * @Author: luoxian
 * @Date: 2019/5/22 16:38
 */
public enum ResultEnum {
    SUCCESS(200,"成功"),
    FAIL(201,"失败"),
    PARAMS_IS_NULL(202,"参数缺失"),
    PARAMS_IS_ERROR(203,"参数值错误"),
    RECORD_NON_EXISTENT(204,"记录不存在"),
    QUERY_TYPE_ERROR(205,"查询类型错误"),
    LOGIN_ERROR(206,"登录用户名或密码错误，请检查后重新登录"),

    EXCEPTION(500,"系统异常"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
