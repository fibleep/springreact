package com.book.springreact.service;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    static final long EXPIRATION_TIME=864_000_00;
    static final String SIGN_IN_KEY="SecretKey";
    static final String PREFIX="Bearer";

    // Add token to authorization header
    static public void addToken(HttpServletResponse res, String username){
        String JwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SIGN_IN_KEY).compact();

        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }
    static public Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null){
            // parse the token
            String user = Jwts.parser()
                    .setSigningKey(SIGN_IN_KEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if(user != null){
                return new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(user, null, new java.util.ArrayList<>());
            }
        }
        return null;

    }


}
