package hello.proxy.pureporoxy.proxy.code;

public class ProxyPatternCline {
    private Subject subject;

    public ProxyPatternCline(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }
}
