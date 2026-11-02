package acro.universe.exception;

import java.time.Instant;

public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,      // "Not Found", "Bad Request", etc.
        String message,    // readable message for user
        String path        // "/api/posts/999"
) {}