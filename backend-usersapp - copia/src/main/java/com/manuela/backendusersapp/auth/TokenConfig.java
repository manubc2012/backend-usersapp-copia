package com.manuela.backendusersapp.auth;

import io.jsonwebtoken.Jwts;
import java.security.Key;


public class TokenConfig {

    //public final static String SECRET_KEY = "algun_token_con_alguna_palabra_secreta";

    public final static Key SECRET_KEY = Jwts.SIG.HS256.key().build();

    public final static String PREFIX_TOKEN = "Bearer ";

    public final static String HEADER_AUTHORIZATION = "Authorization";


    //SecretKey key = Jwts.SIG.HS256.key().build();
}
