package com.yidiandian.elasticsearch;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenTests extends ElasticSearchApplicationTests{

	@Test
	public void createToken(){
      log.info("生成的token:{}",createEasyToken());
	}

	/**
	 * 创建简单token
	 * @return
	 */
	public static String createEasyToken(){
		JwtBuilder builder = Jwts.builder().setId("888").setSubject("凤凰小哥哥")
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"yidiandian");
		return builder.compact();
	}
    @Test
	public void createWithtExpirationTokenTest(){
		log.info("生成带有过期时间的token:{}",createWithtExpirationToken());
	}

	/**
	 * 创建带有过期时间
	 * @return
	 */
	public static String createWithtExpirationToken(){
		//获取当前时间
       long now = System.currentTimeMillis();
       //设置过期时间为1分钟
	   long exp = now + 1000*60;
		JwtBuilder builder = Jwts.builder().setId("888").setSubject("凤凰小哥哥").setIssuedAt(new Date())
			   .signWith(SignatureAlgorithm.HS256,"yidiandian").setExpiration(new Date(exp));
		return builder.compact();
	}

	@Test
	public void parseWebTokenTest(){
		log.info("解析的token:{}",parseWebToken());
	}

	public static Map<String,String> parseWebToken(){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlh6Tlh7DlsI_lk6Xlk6UiLCJpYXQiOjE1NjE1MzgyODV9.RKJyMWF9QvWNb34F_YtH1H6aLCaxZYS2mAfiiIlfKvA";
		Claims claims = Jwts.parser().setSigningKey("yidiandian").parseClaimsJws(token).getBody();
		log.info("得到的数据：",claims.toString());
		Map<String,String> map = new HashMap<>(16);
		map.put("jti",claims.getId());
		map.put("sub",claims.getSubject());
		map.put("iat",sdf.format(claims.getIssuedAt()));
		return map;
	}

	@Test
	public void parseWithtExpirationTokenTest(){
		log.info("解析的token:{}",parseWithtExpirationToken());
	}
	public static Map<String,String> parseWithtExpirationToken(){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String token  = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlh6Tlh7DlsI_lk6Xlk6UiLCJpYXQiOjE1NjE1NDA3NDAsImV4cCI6MTU2MTU0MDgwMH0.dWEb0JtU5vJ9dyJkPZo5BLAnkNJdgtqC4NB6oT2c5aE";
		Claims claims = Jwts.parser().setSigningKey("yidiandian").parseClaimsJws(token).getBody();
		log.info("得到的数据：",claims.toString());
		Map<String,String> map = new HashMap<>(16);
		map.put("jti",claims.getId());
		map.put("sub",claims.getSubject());
		map.put("iat",sdf.format(claims.getIssuedAt()));
		map.put("exp",sdf.format(claims.getExpiration()));
		map.put("now",sdf.format(new Date()));
		return map;
	}
	@Test
	public void createWithtExpirationCustomTokenTest(){
		log.info("生成带有过期时间自定义的token:{}",createWithtExpirationCustomToken());
	}

	/**
	 * 创建带有过期时间的自定义token
	 * @return
	 */
	public static String createWithtExpirationCustomToken(){
		//获取当前时间
		long now = System.currentTimeMillis();
		//设置过期时间为1分钟
		long exp = now + 1000*60*3;
		JwtBuilder builder = Jwts.builder().setId("888").setSubject("凤凰小哥哥")
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"yidiandian")
				.setExpiration(new Date(exp)).claim("mobile","17621007255")
				.claim("gender","男");
		return builder.compact();
	}

	@Test
	public void parseWithtExpirationCustomTokenTest(){
		log.info("解析的token:{}",parseWithtExpirationCustomToken());
	}
	public static Map<String,String> parseWithtExpirationCustomToken(){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String token  = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlh6Tlh7DlsI_lk6Xlk6UiLCJpYXQiOjE1NjE1NDE1OTQsImV4cCI6MTU2MTU0MTc3NCwibW9iaWxlIjoiMTc2MjEwMDcyNTUiLCJnZW5kZXIiOiLnlLcifQ.4naCxbCXkqBehNjOm-l4JNJNUVBPvPowH2OGQxvT6Hg";
		Claims claims = Jwts.parser().setSigningKey("yidiandian").parseClaimsJws(token).getBody();
		log.info("得到的数据：",claims.toString());
		Map<String,String> map = new HashMap<>(16);
		map.put("jti",claims.getId());
		map.put("sub",claims.getSubject());
		map.put("iat",sdf.format(claims.getIssuedAt()));
		map.put("exp",sdf.format(claims.getExpiration()));
		map.put("mobile",claims.get("mobile").toString());
		map.put("gender",claims.get("gender").toString());
		map.put("now",sdf.format(new Date()));
		return map;
	}

}
