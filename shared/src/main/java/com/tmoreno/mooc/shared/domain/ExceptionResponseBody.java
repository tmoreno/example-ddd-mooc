package com.tmoreno.mooc.shared.domain;

import java.time.Instant;

public final class ExceptionResponseBody {

    private final int status;
    private final String message;
    private final String timestamp;

    public ExceptionResponseBody(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = Instant.now().toString();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
