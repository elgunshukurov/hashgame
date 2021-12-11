package com.example.hashgame.model;

public enum Player {
    HUMAN("Human"),
    MACHINE("Machine"),
    NOBODY("Nobody");

    private final String type;

    Player(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
