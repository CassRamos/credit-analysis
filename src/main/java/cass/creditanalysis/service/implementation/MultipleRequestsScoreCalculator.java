package cass.creditanalysis.service.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.ScoreCalculation;

import java.util.Random;

public class MultipleRequestsScoreCalculator implements ScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return hasPendingCreditRequests() ? 0 : 80;
    }

    private boolean hasPendingCreditRequests() {
        return new Random().nextBoolean();
    }
}
