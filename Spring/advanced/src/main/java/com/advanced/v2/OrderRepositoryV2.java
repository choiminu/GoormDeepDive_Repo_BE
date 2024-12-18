package com.advanced.v2;

import com.advanced.hellotrace.HelloTraceV2;
import com.advanced.trace.TraceId;
import com.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {

        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId,"OrderRepository.save()");

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
