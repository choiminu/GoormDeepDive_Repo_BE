package com.board.myboard;

import com.board.myboard.bean.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@SpringBootApplication
public class MyBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBoardApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello bean = (Hello)context.getBean("hello");
        System.out.println(bean.getName());
    }

}
