package cass.creditanalysis.service.implementation;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.ScoreCalculation;

public class IncomeBasedScoreCalculator implements ScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return isIncomeGreaterThanRequestAmount(proposal) ? 100 : 0;
    }

    private boolean isIncomeGreaterThanRequestAmount(Proposal proposal) {
        return proposal.getUser().getIncome() > proposal.getRequestedAmount();
    }

}
