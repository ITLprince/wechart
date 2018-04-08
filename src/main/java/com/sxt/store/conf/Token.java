package com.sxt.store.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Token {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
}
