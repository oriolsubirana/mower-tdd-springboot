package com.oriol.mower.domain.model;

public class Mower {

    String direction = "N";

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void spinLeft() {
        if (direction == "N") {
            direction = "W";
        } else if (direction == "W") {
            direction = "S";
        } else if (direction == "S") {
            direction = "E";
        } else if (direction == "E") {
            direction = "N";
        }
    }

    public void spinRight() {
        if (direction == "N") {
            direction = "E";
        } else if (direction == "E") {
            direction = "S";
        } else if (direction == "S") {
            direction = "W";
        } else if (direction == "W") {
            direction = "N";
        }
    }
}
