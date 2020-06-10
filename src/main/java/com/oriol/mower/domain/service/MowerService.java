package com.oriol.mower.domain.service;

import com.oriol.mower.domain.model.Mower;
import com.oriol.mower.domain.model.Plateau;

public class MowerService {

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char MOVE = 'M';

    public String process(String input, Mower mower, Plateau plateau) {
        for (char command : input.toCharArray()) {
            if (command == LEFT) {
                mower.spinLeft();
            }
            if (command == RIGHT) {
                mower.spinRight();
            }
            if (command == MOVE) {
                mower.move(plateau);
            }
        }
        return mower.toString();
    }
}
