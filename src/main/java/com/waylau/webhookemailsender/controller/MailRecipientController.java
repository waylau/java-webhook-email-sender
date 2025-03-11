package com.waylau.webhookemailsender.controller;

import com.waylau.webhookemailsender.model.MailRecipient;
import com.waylau.webhookemailsender.repository.MailRecipientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * MailRecipientController
 * @author waylau.com
 * @version 2025/03/11 18:02
**/
@RestController
@RequestMapping("/recipients")
public class MailRecipientController {
    private static Logger log = LoggerFactory.getLogger(MailRecipientController.class);

    @Autowired
    private MailRecipientRepository mailRecipientRepository;

    /**
     * 查询所有收件人
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("recipientList", mailRecipientRepository.findAll());
        model.addAttribute("title", "收件人管理");
        return new ModelAndView("recipients/list","recipientModel",model);
    }

    /**
     * 根据 id 查询收件人
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Integer id, Model model) {
        Optional<MailRecipient> recipient = mailRecipientRepository.findById(id);
        model.addAttribute("recipient", recipient.get());
        model.addAttribute("title", "查看收件人");
        return new ModelAndView("recipients/view","recipientModel",model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("recipient", new MailRecipient(null));
        model.addAttribute("title", "创建收件人");
        return new ModelAndView("recipients/form","recipientModel",model);
    }

    /**
     * 保存或者修改收件人
     * @param recipient
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(MailRecipient recipient) {
        mailRecipientRepository.save(recipient);
        return new ModelAndView("redirect:/recipients");// 重定向到 list页面
    }

    /**
     * 删除收件人
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        mailRecipientRepository.deleteById(id);
        return new ModelAndView("redirect:/recipients"); // 重定向到 list页面
    }

    /**
     * 获取修改收件人的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id, Model model) {
        Optional<MailRecipient> recipient = mailRecipientRepository.findById(id);
        model.addAttribute("recipient", recipient.get());
        model.addAttribute("title", "修改收件人");
        return new ModelAndView("recipients/form","recipientModel",model);
    }
}