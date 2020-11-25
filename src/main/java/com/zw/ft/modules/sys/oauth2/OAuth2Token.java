package com.zw.ft.modules.sys.oauth2;


import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @description: shiro token
 * @author: Oliver
 * @date 2020/9/27
 */
@Data
public class OAuth2Token implements AuthenticationToken {

    private final String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
