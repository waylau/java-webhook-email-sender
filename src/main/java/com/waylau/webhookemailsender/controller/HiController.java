package com.waylau.webhookemailsender.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HiController  
 * @author waylau.com
 * @version 2025/03/10 18:02
**/
@RestController
public class HiController {
@RequestMapping("/hi")
    @GetMapping("/webhookemailsender")
    public String hi() {
        return "Java Webhook Email Sender";
    }
}