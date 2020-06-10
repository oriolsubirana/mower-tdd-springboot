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

    public Position changePosition(Plateau plateau) {
        int x = this.x;
        int y = this.y;

        switch (this.direction) {
            case NORTH:
                if (y + 1 <= plateau.getHeight()) {
                    y += 1;
                }
                break;
            case EAST:
                if (x + 1 <= plateau.getWidth()) {
                    x += 1;
                }
                break;
            case WEST:
                if (x - 1 >= 0) {
                    x -= 1;
                }
                break;
            case SOUTH:
                if (y - 1 >= 0) {
                    y -= 1;
                }
                break;

        }
        return new Position(x, y, this.direction);
    }
}
