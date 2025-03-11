package com.waylau.webhookemailsender.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * EmailServiceTest EmailService test 
 * @author waylau.com
 * @version 2025/03/11 09:33
**/
@SpringBootTest
class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @Test
    @Disabled
    public void testSend() {
        String[] to = {"waylau521@gmail.com"};
        emailService.sendSimpleMail(to, "test邮件", "这个是测试邮件内容");
    }
}