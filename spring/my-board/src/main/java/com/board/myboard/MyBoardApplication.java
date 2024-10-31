package com.board.myboard;

import com.board.myboard.bean.ExpController;
import com.board.myboard.bean.ExpService;
import com.board.myboard.bean.scope.ProtoTypeBean;
import com.board.myboard.bean.scope.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MyBoardApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyBoardApplication.class, args);

        ProtoTypeBean protoBean = applicationContext.getBean("protoTypeBean", ProtoTypeBean.class);
        System.out.println("protoBean = " + protoBean);

        SingletonBean singletonBean = applicationContext.getBean("singletonBean", SingletonBean.class);
        System.out.println("singletonBean = " + singletonBean);

//        ExpController expController = applicationContext.getBean("expController", ExpController.class);
//        expController.call();
    }
}
