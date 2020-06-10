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

    public Position changePosition() {
        int x = this.x;
        int y = this.y;

        switch (this.direction) {
            case NORTH:
                y += 1;
                break;
            case EAST:
                x += 1;
                break;
            case WEST:
                x -= 1;
                break;
            case SOUTH:
                y -= 1;
                break;

        }
        return new Position(x, y, this.direction);
    }
}
