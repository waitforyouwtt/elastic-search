package com.yidiandian.elasticsearch.utils;

import com.yidiandian.elasticsearch.constants.FConstant;
import com.yidiandian.elasticsearch.entity.Admin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/26 16:14
 * @Email: 15290810931@163.com
 */
@Slf4j
public class TokenUtils {
    /**
     * 生成token
     * @return
     */
    public static String token(Admin admin){
        //获取当前时间
        long now = System.currentTimeMillis();
        //设置过期时间为1分钟
        long exp = now + FConstant.TOKEN_EXP;
        JwtBuilder builder = Jwts.builder().setId(admin.getUserId()).setSubject(admin.getUserName())
                .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,admin.getUserName())
                .setExpiration(new Date(exp)).claim("mobile",admin.getMobile())
                .claim("gender",admin.getGender()).claim("nickName",admin.getNickName());
        return builder.compact();
    }

    /**
     * 生成token
     * @return
     */
    public static Map<String,String> parseToken(String token,Admin admin){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Claims claims = Jwts.parser().setSigningKey(admin.getUserName()).parseClaimsJws(token).getBody();
        log.info("得到的数据：",claims.toString());
        Map<String,String> map = new HashMap<>(16);
        map.put("jti",claims.getId());
        map.put("sub",claims.getSubject());
        map.put("nickName",claims.get("nickName").toString());
        map.put("iat",sdf.format(claims.getIssuedAt()));
        map.put("exp",sdf.format(claims.getExpiration()));
        map.put("mobile",claims.get("mobile").toString());
        map.put("gender",claims.get("gender").toString());
        map.put("now",sdf.format(new Date()));
        return map;
    }


}
