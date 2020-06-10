package com.oriol.mower.domain.model;

public class Position {

    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void spinLeft() {
        this.direction = direction.spinLeft();
    }

    public void spinRight() {
        this.direction = direction.spinRight();
    }

    public String getDirectionCode() {
        return direction.getShortCode();
    }
}
