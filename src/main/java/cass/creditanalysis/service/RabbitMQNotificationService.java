package cass.creditanalysis.service;

import cass.creditanalysis.domain.Proposal;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQNotificationService {

    private final RabbitTemplate rabbitTemplate;

    public void notify(String exchangeName, Proposal proposal) {
        rabbitTemplate.convertAndSend(exchangeName, "", proposal);
    }
}
