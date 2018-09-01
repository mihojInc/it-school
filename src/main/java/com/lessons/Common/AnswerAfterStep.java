package com.lessons.Common;

import java.io.Serializable;

public enum AnswerAfterStep implements Serializable {
    WRONG_STEP("Wrong step"),
    CORRECT_STEP("Correct step"),
    WNNER("Winner"),
    PLAY_GAME("Play game");

    private String desc;

     AnswerAfterStep(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    //    ANS2("Ans2");

}
