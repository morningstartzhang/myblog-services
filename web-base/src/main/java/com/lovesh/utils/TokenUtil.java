package com.lovesh.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class TokenUtil {

    private static final long EXPIRE_DATE = 60*60*24;

    private static final String TOKEN_SECRET = "dlUmIA9uaQ9phstqC6XjUEUV";

    private static final String ID = "id";

    public static String token(Integer id){
        String token = "";
        
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            HashMap<String, Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            JWT.create().withHeader(header)
                    .withClaim(ID, id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return token;
    }

    public static Integer verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim(ID).asInt();
        }catch (Exception e){
            return 0;
        }
    }


}
