package cass.creditanalysis.service.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.ScoreCalculation;

import java.util.Random;

public class CreditScoreCalculator implements ScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        int score = generateRandomScore();

        if (score < 200) {
            throw new RuntimeException("Score is too low");
        } else if (score <= 450) {
            return 150;
        } else if (score <= 600) {
            return 180;
        } else {
            return 220;
        }
    }

    private int generateRandomScore() {
        return new Random().nextInt(0, 1000);
    }
}
