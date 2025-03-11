package com.waylau.webhookemailsender.model;

import jakarta.persistence.*;

/**
 * EmailEnty 邮件实体 
 * @author waylau.com
 * @version 2025/03/11 10:33
**/
@Entity
@Table(name = "t_mail_recipient")
public class MailRecipient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 自增长策略
    private Integer id;

    private String recipient;

    protected MailRecipient() { // 无参构造函数；设为 protected 防止直接使用
    }

    public MailRecipient( String recipient) {
        this.recipient = recipient;
    }

    public MailRecipient(Integer id, String recipient) {
        this.id = id;
        this.recipient = recipient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return String.format("MailRecipient[id=%d, recipient='%s'']", id, recipient);
    }
}