package com.board.myboard.bean;


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
