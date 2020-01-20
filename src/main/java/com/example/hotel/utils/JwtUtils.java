package com.example.hotel.utils;
import com.example.hotel.entity.User;
import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtils {


    private static  final   String  key = "token";
    private static  final   long   ttlMillis =1000*60*30;
    /**
     * 签发JWT
     * @return  String
     *
     */
    public static String createJWT(User user) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId(user.getAdminId().toString())
                .setSubject(user.getAdminUsername())   // 主题
                .setIssuer("user")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, key); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }
    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static Result validateJWT(String jwtStr) {
       Result checkResult = new Result();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setCode(State.OK.INFO());
        } catch (ExpiredJwtException e) {
            checkResult.setCode(State.FAIL.INFO());
        } catch (SignatureException e) {
            checkResult.setCode(State.FAIL.INFO());
        } catch (Exception e) {
            checkResult.setCode(State.FAIL.INFO());
        }
        return checkResult;
    }

    
    /**
     * 
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        return Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(jwt)
            .getBody();
    }




}