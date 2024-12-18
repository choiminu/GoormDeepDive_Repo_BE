package hello.aop.exam;

import hello.aop.order.exam.ExamService;
import hello.aop.order.exam.Retry;
import hello.aop.order.exam.RetryAspect;
import hello.aop.order.exam.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@Slf4j
//@Import(TraceAspect.class)
@Import({TraceAspect.class, RetryAspect.class})
@SpringBootTest
public class ExamTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            log.info("client request = {}", i);
            examService.request("data" + i);
        }
    }
}
