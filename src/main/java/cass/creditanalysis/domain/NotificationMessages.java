package cass.creditanalysis.domain;

public enum NotificationMessages {

    OPERATION_DENIED("Operation denied. Client %s is blacklisted."),
    LOW_SCORE("Operation denied. Client %s has a low score.");

    private final String message;

    NotificationMessages(String message) {
        this.message = message;
    }

    public String getFormattedMessage(String... parameters) {
        return String.format(message, parameters);
    }
}
