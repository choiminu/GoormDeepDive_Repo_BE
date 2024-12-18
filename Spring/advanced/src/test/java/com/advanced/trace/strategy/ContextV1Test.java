package com.advanced.trace.strategy;

import com.advanced.trace.strategy.code.stategy.ContextV1;
import com.advanced.trace.strategy.code.stategy.Strategy;
import com.advanced.trace.strategy.code.stategy.StrategyLogic1;
import com.advanced.trace.strategy.code.stategy.StrategyLogic2;
import com.advanced.trace.template.code.AbstractTemplate;
import com.advanced.trace.template.code.SubClassLogic1;
import com.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    @Test
    public void strategyV1() {
        StrategyLogic1 strategyLogic1 =new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 =new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    public void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();
    }

    @Test
    public void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        contextV1.execute();
    }

    @Test
    public void strategyV4() {
        ContextV1 context = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
    }
}
