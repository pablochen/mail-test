package com.devhanwha.mailsender.controller;

import com.devhanwha.mailsender.dto.SenderDto;
import com.devhanwha.mailsender.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/mail")
public class MailController {
    @Autowired
    private SenderService senderService;

    @GetMapping("/send")
    public void sendMail(@RequestParam("subject") final String subject,
                         @RequestParam("content") final String content,
                         @RequestParam("rcpt") final String rcpt) {
        List toList = new ArrayList<String>();
        toList.add(rcpt);
        SenderDto dto = SenderDto.builder()
                .from("testyo@devhanwha.net")
                .to(toList)
                .subject(subject)
                .content(content)
                .build();

        senderService.send(dto);
    }
}
