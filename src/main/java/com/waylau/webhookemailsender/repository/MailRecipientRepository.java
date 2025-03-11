package com.waylau.webhookemailsender.repository;

import com.waylau.webhookemailsender.model.MailRecipient;
import org.springframework.data.repository.CrudRepository;

/**
 * MailRecipientRepository MailRecipient Repository 
 * @author waylau.com
 * @version 2025/03/11 11:21
**/
public interface MailRecipientRepository extends CrudRepository<MailRecipient, Integer> {
}