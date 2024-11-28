package hello.proxy.pureporoxy.decorator;

import hello.proxy.pureporoxy.decorator.code.Component;
import hello.proxy.pureporoxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureporoxy.decorator.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecorationPatternTest {
    @Test
    void noDecoration() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
