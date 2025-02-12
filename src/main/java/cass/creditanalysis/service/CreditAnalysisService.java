package cass.creditanalysis.service;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    private List<ScoreCalculation> scoreCalculationList;

    public CreditAnalysisService(List<ScoreCalculation> scoreCalculationList) {
        this.scoreCalculationList = scoreCalculationList;
    }

    public void analyze(Proposal proposal) {
        int finalScore =
                scoreCalculationList
                        .stream()
                        .mapToInt(impl -> impl.calculate(proposal))
                        .sum();
    }
}
