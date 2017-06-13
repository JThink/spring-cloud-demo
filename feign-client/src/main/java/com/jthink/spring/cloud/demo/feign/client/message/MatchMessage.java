package com.jthink.spring.cloud.demo.feign.client.message;

import com.jthink.spring.cloud.demo.feign.client.dto.UserDto;

/**
 * Copyright (C), 2017, xgroup
 *
 * @author qianjc
 * @version 0.0.1
 * @desc 比对返回消息
 * @date 2017-06-13 14:45:06
 */
public class MatchMessage {

    // 匹配到
    public static final int RESULT_MATCHED = 1;
    // 未匹配到
    public static final int RESULT_NO_MATCH = 2;
    // 匹配到的UserDto
    private UserDto userDto;
    // 匹配的结果
    private int result;

    public MatchMessage() {
    }

    public MatchMessage(UserDto userDto, int result) {
        this.userDto = userDto;
        this.result = result;
    }

    @Override
    public String toString() {
        return "MatchMessage{" +
                "userDto=" + userDto +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchMessage that = (MatchMessage) o;

        if (result != that.result) return false;
        return userDto != null ? userDto.equals(that.userDto) : that.userDto == null;
    }

    @Override
    public int hashCode() {
        int result1 = userDto != null ? userDto.hashCode() : 0;
        result1 = 31 * result1 + result;
        return result1;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public MatchMessage setUserDto(UserDto userDto) {
        this.userDto = userDto;
        return this;
    }

    public int getResult() {
        return result;
    }

    public MatchMessage setResult(int result) {
        this.result = result;
        return this;
    }
}
