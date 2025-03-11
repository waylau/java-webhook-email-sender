package com.waylau.webhookemailsender.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * MainController
 * @author waylau.com
 * @version 2025/03/11 18:02
**/
@RestController
@RequestMapping("/")
public class MainController {
    private static Logger log = LoggerFactory.getLogger(MainController.class);

    /**
     * 重定向到收件人列表页面
     * @return
     */
    @GetMapping
    public ModelAndView redirectToRecipients() {
        return new ModelAndView("redirect:/recipients");// 重定向到 list页面
    }

}