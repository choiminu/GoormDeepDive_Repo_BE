package com.advanced.v1;

import com.advanced.hellotrace.HelloTraceV1;
import com.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

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
