package com.oriol.mower.domain.service;

import com.oriol.mower.domain.model.Mower;

public class MowerService {

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public String process(String input, Mower mower) {
        for (char rotation : input.toCharArray()) {
            if (rotation == LEFT) {
                mower.spinLeft();
            }
            if (rotation == RIGHT) {
                mower.spinRight();
            }
        }
        return mower.toString();
    }
}
