package cass.creditanalysis.listener;

import cass.creditanalysis.domain.Proposal;
import cass.creditanalysis.service.CreditAnalysisService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnderReviewProposalListener {

    private final CreditAnalysisService creditAnalysisService;

    public UnderReviewProposalListener(CreditAnalysisService creditAnalysisService) {
        this.creditAnalysisService = creditAnalysisService;
    }

    @RabbitListener(queues = "${rabbitmq.pending-proposal.credit-analysis}")
    public void UnderReviewProposal(Proposal proposal) {
        creditAnalysisService.analyze(proposal);
    }
}
