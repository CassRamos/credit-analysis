package cass.creditanalysis.service.strategy.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MultipleRequestsScoreCalculator implements ScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return hasPendingCreditRequests() ? 0 : 80;
    }

    private boolean hasPendingCreditRequests() {
        return new Random().nextBoolean();
    }
}
