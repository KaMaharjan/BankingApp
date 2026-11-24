package model;

import java.time.LocalDateTime;
import java.util.List;

public record AccountNote(
        long bankAccountId,
        long authorId,
        String note,
        LocalDateTime timestamp,
        Long transactionId,
        List<String> tags
) {}
