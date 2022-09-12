package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void mailTests(){
        mailClient.sendMail("projectssevice@sina.com","test","welcome!");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","sunday");
        String content = templateEngine.process("/mail/demo",context);
        System.out.println(content);

        mailClient.sendMail("2417983039@qq.com","HTML", content);



    }
}
