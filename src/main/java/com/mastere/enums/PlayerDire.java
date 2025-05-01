package com.mastere.enums;

public enum PlayerDire {
    UP("up"), DOWN("down"), LEFT("left"), RIGHT("right");

    private final String name;

    PlayerDire(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
