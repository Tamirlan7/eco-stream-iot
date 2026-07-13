package com.tami.alertservice.service;

import com.tami.alertservice.entity.Alert;
import com.tami.alertservice.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final AlertRepository alertRepository;

    public void sendEmail(String to, String subject, String body, Long userId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("com-tami-iot@example.com");
        message.setSubject(subject);
        message.setText(body);

        try {
            mailSender.send(message);
            Alert alert = Alert.builder()
                    .userId(userId)
                    .sent(true)
                    .build();

            alertRepository.saveAndFlush(alert);
            alertRepository.saveAndFlush(alert);
        } catch (MailException ex) {
            log.error("Failed to send an email to: {}", to, ex);

            Alert alert = Alert.builder()
                    .userId(userId)
                    .sent(false)
                    .build();

            alertRepository.saveAndFlush(alert);
        }

        log.info("Email sent to: {}", to);
    }

}
