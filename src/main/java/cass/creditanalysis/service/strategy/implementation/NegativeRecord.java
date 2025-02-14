package cass.creditanalysis.service.strategy.implementation;

import cass.creditanalysis.domain.NotificationMessages;
import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.exception.StrategyException;
import cass.creditanalysis.service.strategy.ScoreCalculation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NegativeRecord implements ScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        if (isBlacklisted()) {
            String message = NotificationMessages.OPERATION_DENIED.getFormattedMessage(proposal.getUser().getName());
            throw new StrategyException(message);
        }
        return 100;
    }

    private boolean isBlacklisted() {
        return new Random().nextBoolean();
    }
}
