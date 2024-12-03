package hello.proxy.pureporoxy.jdkdynamic;

import hello.proxy.pureporoxy.jdkdynamic.code.AImpl;
import hello.proxy.pureporoxy.jdkdynamic.code.AInterface;
import hello.proxy.pureporoxy.jdkdynamic.code.BImpl;
import hello.proxy.pureporoxy.jdkdynamic.code.BInterface;
import hello.proxy.pureporoxy.jdkdynamic.code.TimeInvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdkDynamicProxyTest {


    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface)Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxy={}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface)Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxy={}", proxy.getClass());
    }
}
