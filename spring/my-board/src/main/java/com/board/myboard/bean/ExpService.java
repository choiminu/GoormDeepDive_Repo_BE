package com.board.myboard.bean;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ExpService {
    public void logic(String name, int exp) {
        System.out.println(name + " 님의" + " 경험치는 = " + exp + " 입니다.");
    }
}
