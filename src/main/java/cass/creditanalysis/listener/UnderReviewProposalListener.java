package cass.creditanalysis.listener;

import cass.creditanalysis.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnderReviewProposalListener {

    @RabbitListener(queues = "${rabbitmq.pending-proposal.credit-analysis}")
    public void UnderReviewProposal(Proposal proposal) {
    }
}
