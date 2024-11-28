package com.advanced.trace.callback;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace logTrace) {
        this.trace = logTrace;
    }

    public <T> T execute(String message, TraceCallBack<T> call) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = call.callback();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
