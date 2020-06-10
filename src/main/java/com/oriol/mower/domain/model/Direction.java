package com.oriol.mower.domain.model;

public enum Direction {
    NORTH("N", "W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E", "N", "S"),
    WEST("W", "S", "N");

    private String shortCode;
    private String left;
    private String right;

    Direction(String shortCode, String left, String right) {
        this.shortCode = shortCode;
        this.left = left;
        this.right = right;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public Direction spinLeft() {
        return getNextDirection(left);
    }

    public Direction spinRight() {
        return getNextDirection(right);
    }

    public Direction getNextDirection(String value) {
        for (Direction direction : values()) {
            if (direction.shortCode == value) {
                return direction;
            }
        }
        return null;
    }
}
