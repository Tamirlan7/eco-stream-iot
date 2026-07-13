package com.tami.alertservice.service;

import com.tami.alertservice.kafka.event.AlertingEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AlertService {

    private final MailService mailService;

    @KafkaListener(topics = "energy-alerts", groupId = "alert-service")
    public void consumeEnergyAlerts(AlertingEvent alertingEvent) {
        log.info("Received alerting event {}", alertingEvent);

        final String subject = "Energy Usage Alert for User " +
                alertingEvent.userId();

        final String message = "Alert: " + alertingEvent.message() +
                "\nThreshold: " + alertingEvent.threshold() +
                "\nEnergy Consumed: " + alertingEvent.energyConsumed();

        mailService.sendEmail(alertingEvent.email(), subject, message, alertingEvent.userId());
    }

}
