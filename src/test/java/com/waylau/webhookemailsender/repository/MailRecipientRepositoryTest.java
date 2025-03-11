package com.waylau.webhookemailsender.repository;

import com.waylau.webhookemailsender.model.MailRecipient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MailRecipientRepositoryTest MailRecipientRepository test 
 * @author wayla 
 * @version 2025/03/11 11:25
**/
@SpringBootTest
class MailRecipientRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(MailRecipientRepositoryTest.class);

    @Autowired
    private MailRecipientRepository mailRecipientRepository;

    @Test
    public void testFindAll() {
        mailRecipientRepository.save(new MailRecipient("way"));
        mailRecipientRepository.save(new MailRecipient("way2"));
        mailRecipientRepository.save(new MailRecipient("way3"));


        Iterable<MailRecipient> recipientList = mailRecipientRepository.findAll();

        recipientList.forEach(recipient -> {
            log.info("MailRecipient: {}", recipient);
        });
    }
}