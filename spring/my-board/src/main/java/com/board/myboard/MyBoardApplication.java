package com.board.myboard;

import com.board.myboard.bean.ExpController;
import com.board.myboard.bean.ExpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MyBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBoardApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ExpController controller = (ExpController) context.getBean("expController");

        controller.call();
    }

}
