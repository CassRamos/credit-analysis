package cass.creditanalysis.service.strategy.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Component;

@Component
public class IncomeBasedScoreCalculator implements ScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return isIncomeGreaterThanRequestAmount(proposal) ? 100 : 0;
    }

    private boolean isIncomeGreaterThanRequestAmount(Proposal proposal) {
        return proposal.getUser().getIncome() > proposal.getRequestedAmount();
    }

}
