package com.example.hotel.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

    public static String getUUid(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        //生成
        JwtBuilder jwtBuilder = Jwts.builder().setId("用户ID")
                .setSubject("用户名")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"token")
                .setExpiration(new Date(System.currentTimeMillis()+60000))
                .claim("role","admin");
                ;

        System.out.println(jwtBuilder.compact());


        //解析
        Claims token = Jwts.parser().setSigningKey("token")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiLnlKjmiLdJRCIsInN1YiI6IueUqOaIt-WQjSIsImlhdCI6MTU3OTM2Mjc3MywiZXhwIjoxNTc5MzYyODMzfQ.50D1ZHkm3ROOAR1D0or5IPYyAXnesf2M-uwlrgxA7pA")
                .getBody();
        System.out.println("token = " + token);

    }


}
