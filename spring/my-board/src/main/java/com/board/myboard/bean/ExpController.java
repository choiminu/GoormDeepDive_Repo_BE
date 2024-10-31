package com.board.myboard.bean;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ExpController {

    private final ExpService expService;

    public void call() {
        expService.logic("민우", 100);
    }

}
