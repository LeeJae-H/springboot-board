package com.jaeh.jh.model.user;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Sex {

    M("M", "남자"),
    W("W", "여자");

    private final String stringValue;
    private final String status;

    Sex(String stringValue, String status) {
        this.stringValue = stringValue;
        this.status = status;
    }

    public static Sex ofStringValue(String stringValue) {
        return Arrays.stream(Sex.values())
                .filter(v -> v.getStringValue().equals(stringValue))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 성별입니다: " + stringValue));
    }

    public static Sex ofStatus(String status) {
        return Arrays.stream(Sex.values())
                .filter(v -> v.getStatus().equals(status))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 성별 상태입니다: " + status));
    }
}
