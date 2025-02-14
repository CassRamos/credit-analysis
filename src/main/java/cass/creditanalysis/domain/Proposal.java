package cass.creditanalysis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposal {

    private Long id;
    private Double requestedAmount;
    private int paymentDeadline;
    private Boolean approved;
    private boolean integrated;
    private String note;

    private User user;
}