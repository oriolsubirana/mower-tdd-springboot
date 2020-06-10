package com.oriol.mower.domain.service;

import com.oriol.mower.domain.model.Mower;

public class MowerService {

    public String process(String input, Mower mower) {
        for (char rotation : input.toCharArray()) {
            if (rotation == 'L') {
                mower.spinLeft();
            }
            if (rotation == 'R') {
                mower.spinRight();
            }
        }
        return "0 0 " + mower.getDirection();
    }
}
