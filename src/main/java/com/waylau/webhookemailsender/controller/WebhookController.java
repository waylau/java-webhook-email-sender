package com.waylau.webhookemailsender.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.webhookemailsender.model.MailRecipient;
import com.waylau.webhookemailsender.model.SkyWalkingAlarmMessage;
import com.waylau.webhookemailsender.repository.MailRecipientRepository;
import com.waylau.webhookemailsender.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * WebhookController
 * @author waylau.com
 * @version 2025/03/10 18:02
**/
@RestController
@RequestMapping("/webhook")
public class WebhookController {
    private static Logger log = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private MailRecipientRepository mailRecipientRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/skywalking")
    public void  sendEmail(@RequestBody List<SkyWalkingAlarmMessage> alarmMessageList){
        try {
            if (alarmMessageList != null && alarmMessageList.size() > 0){
                Iterable<MailRecipient> recipientList = mailRecipientRepository.findAll();

                int count = (int) mailRecipientRepository.count();

                String[] recipientArray = new String[count];
                int i = 0;
                Iterator<MailRecipient> iterator = recipientList.iterator();
                while (iterator.hasNext()) {
                    recipientArray[i] = iterator.next().getRecipient();
                    i ++;
                }

                ObjectMapper mapper = new ObjectMapper();
                String jsonContent = mapper.writeValueAsString(alarmMessageList);
                emailService.sendSimpleMail(recipientArray, "APM性能告警", jsonContent);
            }
        }catch (Exception e){
            log.error("邮箱发送失败 error:{}", e.getMessage());
        }
    }

}