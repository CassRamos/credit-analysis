package cass.creditanalysis.service.strategy.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.strategy.ScoreCalculation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
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
