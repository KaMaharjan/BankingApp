package model;

import java.util.Date;
import java.util.List;

public record AccountNote(
        List<Category> categoryTags,
        long bankAccountId,
        long authorId,
        String note,
        Date timestamp,
        Long transactionId
) {
    public enum Category {
        GENERAL,
        WIRE_TRANSFER,
        SUSPICIOUS_ACTIVITY,
        CUSTOMER_CONTACT
    }
}
