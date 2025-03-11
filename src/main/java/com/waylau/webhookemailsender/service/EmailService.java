package com.waylau.webhookemailsender.service;

/**
 * EmailService 邮件服务 
 * @author waylau.com
 * @version 2025/03/11 08:57
**/
public interface EmailService {
    void sendSimpleMail(String[] to, String subject, String content);
}