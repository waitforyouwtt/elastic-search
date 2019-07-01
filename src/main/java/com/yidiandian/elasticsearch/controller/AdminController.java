package com.yidiandian.elasticsearch.controller;

import com.yidiandian.elasticsearch.config.JwtUtil;
import com.yidiandian.elasticsearch.entity.Admin;
import com.yidiandian.elasticsearch.entity.Article;
import com.yidiandian.elasticsearch.service.AdminService;
import com.yidiandian.elasticsearch.service.ArticleService;
import com.yidiandian.elasticsearch.utils.MyException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/6 17:44
 * @Email: 15290810931@163.com
 */
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String,String> login(Admin params){
        Admin result = adminService.findAdmin(params,2);
        String token = jwtUtil.createJWT(result.getUserId(), result.getNickName(), "admin");
        Map<String,String> map = new HashMap(16);
        map.put("token",token);
        map.put("nickName",result.getNickName());
        return map;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(HttpServletRequest request,@PathVariable String id){
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.isBlank(authHeader)){
            throw new MyException("权限不足");
        }
        if (!authHeader.startsWith("Bearer")){
            throw new MyException("权限不足");
        }
        String token = authHeader.substring(7);
        Claims claims = jwtUtil.parseJWT(token);
        if (claims == null){
            throw new MyException("权限不足");
        }
        if (!"admin".equals(claims.get("roles"))){
            throw new MyException("权限不足");
        }
        adminService.deleteById(id);
    }

}
