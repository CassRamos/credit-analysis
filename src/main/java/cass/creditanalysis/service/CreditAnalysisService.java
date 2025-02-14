package cass.creditanalysis.service;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.exception.StrategyException;
import cass.creditanalysis.service.strategy.ScoreCalculation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    private final List<ScoreCalculation> scoreCalculationList;
    private final RabbitMQNotificationService rabbitMQNotificationService;
    private final String completedProposalExchange;

    public CreditAnalysisService(List<ScoreCalculation> scoreCalculationList,
                                 RabbitMQNotificationService rabbitMQNotificationService,
                                 @Value("${rabbitmq.completed-proposal.exchange}") String completedProposalExchange) {
        this.scoreCalculationList = scoreCalculationList;
        this.rabbitMQNotificationService = rabbitMQNotificationService;
        this.completedProposalExchange = completedProposalExchange;
    }

    public void analyze(Proposal proposal) {
        try {
            int finalScore =
                    scoreCalculationList
                            .stream()
                            .mapToInt(impl -> impl.calculate(proposal))
                            .sum();
            proposal.setApproved(finalScore >= 300);
        } catch (StrategyException ex) {
            proposal.setApproved(false);
            proposal.setNote(ex.getMessage());
        }
        rabbitMQNotificationService.notify(completedProposalExchange, proposal);
    }
}
