package com.airtek.CURL.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

@Getter
@Setter
public class AirtekToken {
    private ArrayList<String> modules;
    private ArrayList<String> roles;
    private String username;
    private String sub;
    private String customerNumber;
    private String uuid;
    private int iat;
    private int exp;

    public AirtekToken() {
    }

    public AirtekToken(Claims body) throws ExpiredJwtException, JwtException, NoSuchAlgorithmException,
            InvalidKeySpecException, ClassCastException {
        if (body != null && body.get("username") != null) {
            setUsername((String) body.get("username"));
        }
        if (body != null && body.get("customerNumber") != null) {
            setCustomerNumber((String) body.get("customerNumber"));
        }
        if (body != null && body.get("uuid") != null) {
            setUuid((String) body.get("uuid"));
        }
        if (body != null && body.get("iat") != null) {
            setIat((Integer) body.get("iat"));
        }
        if (body != null && body.get("exp") != null) {
            setExp((Integer) body.get("exp"));
        }
        if (body != null && body.get("modules") != null) {
            setModules((ArrayList<String>) body.get("modules"));
        }
        if (body != null && body.get("roles") != null) {
            setRoles((ArrayList<String>) body.get("roles"));
        }
    }
}
