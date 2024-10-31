package com.board.myboard.bean;

import lombok.Data;

@Data
public class ExpService {
    public void logic(String name, int exp) {
        System.out.println(name + " 님의" + " 경험치는 = " + exp + " 입니다.");
    }
}
