package hello.aop.order.exam;

import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {
    private static int seq = 0;

    @Trace
    @Retry
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalArgumentException("예외 발생!");
        }
        return "ok";
    }
}
