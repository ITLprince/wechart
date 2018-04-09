package com.sxt.store.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "wechart")
public class WeCharConfig {

    @Getter
    @Setter
    private String appID;
    @Getter
    @Setter
    private String appsecret;

    @Autowired
    private RestTemplate restTemplate;
    public static final String URL_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    public static final String SEND_MESSAGE="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    public static String tokenAccess;
    @Scheduled(fixedRate=1000*60*60*2,initialDelay=2)
    public void getToken(){
        Token tokenObject = restTemplate.getForObject(String.format(URL_TOKEN, appID, appsecret), Token.class);
        if(null!=tokenObject){
            tokenAccess=tokenObject.getAccessToken();
            System.out.println(tokenAccess);
        }

    }


}
