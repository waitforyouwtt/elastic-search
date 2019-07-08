package com.yidiandian.elasticsearch.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/6/28 9:46
 * @Email: 15290810931@163.com
 */
/*@ConfigurationProperties("jwt.config")
public class JwtUtil {
    private String key;*/
    //一个小时
/*    private long ttl ;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }*/
    /**
     * 生成JWT
     * @param id
     * @param subject
     * @param roles
     * @return
     */
  /*  public String createJWT(String id,String subject,String roles){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256,key).claim("roles",roles);
        if (ttl > 0){
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }*/

    /**
     * 解析jwt
     * @param jwtStr
     * @return
     */
  /*  public Claims parseJWT(String jwtStr){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtStr)
                .getBody();
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }*/
/*}*/
