package com.board.myboard.task.bean.scope;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
@Slf4j
public class SingletonBean {

    public SingletonBean() {
        log.info("SingletonBean 객체가 생성됨.");
    }

    @PreDestroy
    public void destroy() {
        log.info("SingletonBean 객체가 소멸됨.");
    }
}
