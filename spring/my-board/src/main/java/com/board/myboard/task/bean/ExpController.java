package com.board.myboard.task.bean;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ExpController {

    private final ExpServiceImpl expServiceImpl;


    public void call() {
        expServiceImpl.logic("민우", 100);
    }

}
