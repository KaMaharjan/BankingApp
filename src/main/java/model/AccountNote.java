package model;

import java.util.Date;
import java.util.Optional;

public class AccountNote {
    private enum Category {
        GENERAL,
        WIRE_TRANSFER,
        SUSPICIOUS_ACTIVITY,
        CUSTOMER_CONTACT
    }

    private long customerAccountId;
    private long authorEmployeeId;
    private Category category;
    private String note;
    private Date timestamp;
    private Optional<Long> transactionId;
}
