package com.advanced.v5;

import com.advanced.trace.callback.TraceCallBack;
import com.advanced.trace.callback.TraceTemplate;
import com.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new TraceCallBack<String>() {
            @Override
            public String callback() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
