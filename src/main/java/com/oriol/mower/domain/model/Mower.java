package com.oriol.mower.domain.model;

public class Mower {

    Position position;

    public Mower(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void spinLeft() {
        this.position.spinLeft();
    }

    public void spinRight() {
        this.position.spinRight();
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + position.getDirectionCode();
    }

}
