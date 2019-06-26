package com.yidiandian.elasticsearch.service.impl;

import com.yidiandian.elasticsearch.entity.Admin;
import com.yidiandian.elasticsearch.enums.ResultEnum;
import com.yidiandian.elasticsearch.mapper.AdminMapper;
import com.yidiandian.elasticsearch.service.AdminService;
import com.yidiandian.elasticsearch.utils.GenerateUtil;
import com.yidiandian.elasticsearch.utils.MyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/25 17:21
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public Admin save(Admin admin) {
        String code = GenerateUtil.autoCode(6);
        admin.setId(code);
        admin.setUserId(code);
        //密码加密
        admin.setPassword(encoder.encode(admin.getPassword()));
        return adminMapper.save(admin);
    }

    @Override
    public Admin findAdmin(Admin admin,Integer queryType)  {
        Admin result ;
        switch (queryType){
            case 1:
                result = findUserName(admin);
                break;
            case 2:
                result = findUserNameAndPassword(admin);
                break;
            case 3:
                result = findNickNameAndPassword(admin);
                break;
            case 4:
                result = findMobileAndPassword(admin);
                break;
                default:
                    throw new MyException(ResultEnum.QUERY_TYPE_ERROR.getCode(),ResultEnum.QUERY_TYPE_ERROR.getMsg());
        }
        return result;
    }
    /**
     * 根据名字查询
     * @param admin
     * @return
     */
    private  Admin findUserName(Admin admin){
        if (StringUtils.isBlank(admin.getUserName())){
            throw new MyException(ResultEnum.PARAMS_IS_NULL.getCode(),ResultEnum.PARAMS_IS_NULL.getMsg());
        }
        return adminMapper.findAdminByUserName(admin.getUserName());
    }
    /**
     * 根据用户名字和密码查询
     * @param admin
     * @return
     */
    Admin findUserNameAndPassword(Admin admin){
       if (StringUtils.isBlank(admin.getUserName()) || StringUtils.isBlank(admin.getPassword())){
           throw new MyException(ResultEnum.PARAMS_IS_NULL.getCode(),ResultEnum.PARAMS_IS_NULL.getMsg());
       }
       Admin queryAdmin = adminMapper.findAdminByUserName(admin.getUserName());
       if (queryAdmin == null){
           throw new MyException(ResultEnum.RECORD_NON_EXISTENT.getCode(),ResultEnum.RECORD_NON_EXISTENT.getMsg());
       }
       if (!encoder.matches(admin.getPassword(),queryAdmin.getPassword())){
           throw new MyException(ResultEnum.LOGIN_ERROR.getCode(),ResultEnum.LOGIN_ERROR.getMsg());
       }
       Admin result = queryAdmin;
       return result;
    }
    /**
     * 根据昵称和密码查询
     * @param admin
     * @return
     */
    Admin findNickNameAndPassword(Admin admin){
        if (StringUtils.isBlank(admin.getNickName()) || StringUtils.isBlank(admin.getPassword())){
            throw new MyException(ResultEnum.PARAMS_IS_NULL.getCode(),ResultEnum.PARAMS_IS_NULL.getMsg());
        }
        Admin queryAdmin = adminMapper.findAdminByNickName(admin.getNickName());
        if (queryAdmin == null){
            throw new MyException(ResultEnum.RECORD_NON_EXISTENT.getCode(),ResultEnum.RECORD_NON_EXISTENT.getMsg());
        }
        if (!encoder.matches(admin.getPassword(),queryAdmin.getPassword())){
            throw new MyException(ResultEnum.LOGIN_ERROR.getCode(),ResultEnum.LOGIN_ERROR.getMsg());
        }
        Admin result = queryAdmin;
        return result;
    }
    /**
     * 根据手机号查询
     * @param admin
     * @return
     */
    Admin findMobileAndPassword(Admin admin){
        if (StringUtils.isBlank(admin.getMobile()) || StringUtils.isBlank(admin.getPassword())){
            throw new MyException(ResultEnum.PARAMS_IS_NULL.getCode(),ResultEnum.PARAMS_IS_NULL.getMsg());
        }
        Admin queryAdmin = adminMapper.findAdminByMobile(admin.getMobile());
        if (queryAdmin == null){
            throw new MyException(ResultEnum.RECORD_NON_EXISTENT.getCode(),ResultEnum.RECORD_NON_EXISTENT.getMsg());
        }
        if (!encoder.matches(admin.getPassword(),queryAdmin.getPassword())){
            throw new MyException(ResultEnum.LOGIN_ERROR.getCode(),ResultEnum.LOGIN_ERROR.getMsg());
        }
        Admin result = queryAdmin;
        return result;
    }


}
