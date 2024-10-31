package com.board.myboard;

import com.board.myboard.bean.ExpController;
import com.board.myboard.bean.ExpService;
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

        ExpController expController = applicationContext.getBean("expController", ExpController.class);

        expController.call();

    }
}
