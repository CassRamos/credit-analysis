package cass.creditanalysis.service.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.ScoreCalculation;

import java.util.Random;

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
