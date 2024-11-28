package hello.proxy.pureporoxy.decorator;

import hello.proxy.pureporoxy.decorator.code.Component;
import hello.proxy.pureporoxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureporoxy.decorator.code.MessageDecorator;
import hello.proxy.pureporoxy.decorator.code.RealComponent;
import hello.proxy.pureporoxy.decorator.code.TimeDecorator;
import org.junit.jupiter.api.Test;

public class DecorationPatternTest {
    @Test
    void noDecoration() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void Decoration1() {
        Component realComponent = new RealComponent();
        MessageDecorator decorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);
        client.execute();
    }

    @Test
    void Decoration2() {
        Component realComponent = new RealComponent();
        MessageDecorator decorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(decorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
