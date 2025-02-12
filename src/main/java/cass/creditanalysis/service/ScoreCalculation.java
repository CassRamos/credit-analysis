package cass.creditanalysis.service;

import cass.creditanalysis.domain.Proposal;

public interface ScoreCalculation {

    int calculate(Proposal proposal);
}
