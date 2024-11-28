package hello.proxy.pureporoxy.proxy;

import hello.proxy.pureporoxy.proxy.code.CacheProxy;
import hello.proxy.pureporoxy.proxy.code.ProxyPatternCline;
import hello.proxy.pureporoxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {
    @Test
    void noProxy() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternCline proxyPatternCline = new ProxyPatternCline(realSubject);
        proxyPatternCline.execute();
        proxyPatternCline.execute();
        proxyPatternCline.execute();
    }

    @Test
    void cacheProxy() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternCline proxyPatternCline = new ProxyPatternCline(cacheProxy);

        proxyPatternCline.execute();
        proxyPatternCline.execute();
        proxyPatternCline.execute();
    }
}
