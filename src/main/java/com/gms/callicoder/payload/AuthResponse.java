package com.gms.callicoder.payload;

public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String loggedInAccountId;

    public AuthResponse(String accessToken, String loggedInAccountId) {
        this.accessToken = accessToken;
        this.loggedInAccountId = loggedInAccountId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getLoggedInAccountId() {
        return loggedInAccountId;
    }

    public void setLoggedInAccountId(String loggedInAccountId) {
        this.loggedInAccountId = loggedInAccountId;
    }
}
