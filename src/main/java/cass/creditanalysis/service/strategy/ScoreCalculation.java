package cass.creditanalysis.service.strategy;

import cass.creditanalysis.domain.Proposal;

public interface ScoreCalculation {

    int calculate(Proposal proposal);
}
