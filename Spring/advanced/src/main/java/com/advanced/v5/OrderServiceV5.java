package com.advanced.v5;

import com.advanced.trace.callback.TraceCallBack;
import com.advanced.trace.callback.TraceTemplate;
import com.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", new TraceCallBack<Void>() {
            @Override
            public Void callback() {
                orderRepository.save(itemId);
                return null;
            }
        });
    }
}
