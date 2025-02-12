package cass.creditanalysis.service.strategy.implementation;

import cass.creditanalysis.domain.Proposal;
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
            throw new RuntimeException("Proposal has a negative record");
        }
        return 100;
    }

    private boolean isBlacklisted() {
        return new Random().nextBoolean();
    }
}
