package com.sxt.store.service.impl;

import com.sxt.store.conf.WeCharConfig;
import com.sxt.store.dao.UserDao;
import com.sxt.store.domain.User;
import com.sxt.store.service.WeChartService;
import com.sxt.store.wechart.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeChartServiceImpl implements WeChartService {
    @Autowired
    private RestTemplate restTemplate ;
    @Autowired
    private UserDao userDao;

    @Override
    public String sendMessage() {
        StringBuffer sb = new StringBuffer();
        List<User> userList = userDao.findAll();
        userList.forEach((user)-> sb.append(sendMessageToEachUser(user)));
        return sb.toString();

    }

    private String sendMessageToEachUser(User user){
        Template template = new Template();
        template.setTouser(user.getOpenid());
        template.setTemplateId("GC9QT2dxWKFeXPzpqI7_jodHV1T96dl5WltPbNnyhps");

        template.setUrl("www.10010.com");
        template.interData("手机话费余额提醒","#085bdd","first")
                .interData("月度提醒","","keynote1")
                .interData("您已欠费666.0元,请及时充值确保正常使用！","","keynote1")
                .interData("点击详情可查看详细信息>>>", "#085bdd", "remark");

        return restTemplate.postForObject(String.format(WeCharConfig.SEND_MESSAGE,WeCharConfig.tokenAccess),template,String.class)+"::"+user.getUname();

    }
}
