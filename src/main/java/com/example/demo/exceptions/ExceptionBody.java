package com.example.demo.exceptions;

import java.util.List;

public class ExceptionBody {
    private List<String> message;
    private long timestamp;

    public ExceptionBody() {}

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
