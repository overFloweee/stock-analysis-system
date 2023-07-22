package com.hjw;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


class StockAnalysisSystemApplicationTests
{

    @Test
    void contextLoads()
    {
        String url = "http://stockpage.10jqka.com.cn/301132/";
        //         请求客户端
        RestTemplate client = new RestTemplate();
        //      发起请求
        String body = client.getForEntity(url, String.class).getBody();
        System.out.println("******** Get请求 *********");
        assert body != null;
        System.out.println(body);

    }

    // 生成JWT
    @Test
    public void test()
    {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");

        String jwt = Jwts.builder()  // 构建jwt
                .signWith(SignatureAlgorithm.HS256, "itheima") // 设置签名算法 和 签名秘钥
                .setClaims(claims)  // 自定义载荷
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置有效期
                .compact();

        System.out.println(jwt); // eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjg5NjAyODgwLCJ1c2VybmFtZSI6IlRvbSJ9.6BD5pwbv0cNYgjb14RM7t5SD3OcrMFQ5MUFlngsVEjw
    }

    // 解析JWT
    @Test
    public void test1()
    {
        Claims body = Jwts.parser()   // 解析方法
                .setSigningKey("itheima") // 设置签名 秘钥
                // 解析 JWT令牌
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjg5NjAyODgwLCJ1c2VybmFtZSI6IlRvbSJ9.6BD5pwbv0cNYgjb14RM7t5SD3OcrMFQ5MUFlngsVEjw") // 解析 JWT令牌
                .getBody();

        System.out.println(body);
    }
}
