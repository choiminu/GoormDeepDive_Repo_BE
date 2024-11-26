package com.advanced.v3;

import com.advanced.hellotrace.HelloTraceV2;
import com.advanced.trace.TraceId;
import com.advanced.trace.TraceStatus;
import com.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.save()");

            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외 발생");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int mlilis) {
        try {
            Thread.sleep(mlilis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
