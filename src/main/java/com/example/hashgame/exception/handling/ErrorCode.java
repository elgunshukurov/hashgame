package com.example.hashgame.exception.handling;

public enum ErrorCode {
    ILLEGAL_ARGUMENT(10, "illegal_argument"),
    INVALID_HASH_MOVE(11, "invalid_hash_move"),
    UNSUPPORTED_PLAYER_TYPE(12, "unsupported_player_type");

    private final int id;
    private final String code;

    ErrorCode(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
}
