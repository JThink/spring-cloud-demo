package com.jthink.spring.cloud.demo.hystrix.client.dto;

/**
 * Copyright (C), 2017, xgroup
 *
 * @author qianjc
 * @version 0.0.1
 * @desc 微服务接口的参数
 * @date 2017-06-13 11:26:43
 */
public class UserDto {

    private String name;

    private Integer age;

    public UserDto() {
    }

    public UserDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (name != null ? !name.equals(userDto.name) : userDto.name != null) return false;
        return age != null ? age.equals(userDto.age) : userDto.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
