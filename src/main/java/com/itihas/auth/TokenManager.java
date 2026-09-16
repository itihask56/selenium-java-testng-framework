package com.itihas.auth;

import com.itihas.utils.ConfigReader;

public class TokenManager {

    private TokenManager(){}

    public static String getToken(UserRole role){

        String env =
                System.getProperty("env","QA");

        String key =
                env.toUpperCase()
                        + "_"
                        + role.name()
                        + "_TOKEN";

        String token =
                ConfigReader.getEnv(key);

        if(token == null || token.isBlank()){
            throw new RuntimeException(
                    "Token not found for key: " + key
            );
        }

        return token;
    }
}