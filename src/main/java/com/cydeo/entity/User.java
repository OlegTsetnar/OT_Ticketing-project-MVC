package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
/**
 * When we work with Lombok we don't put @allArgsConstructor, because when we extend from a class Lombok will not create full args constructor included Super fields from parent class
 */
@Data
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private long phone;
    private String passWord;
    private Gender gender;
    private Role role;
    private boolean enabled;

    public User(Long id, LocalDateTime insertDateTime, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstName, String lastName, String userName, long phone, String passWord, Gender gender, Role role, boolean enabled) {
        super(id, insertDateTime, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phone = phone;
        this.passWord = passWord;
        this.gender = gender;
        this.role = role;
        this.enabled = enabled;
    }
}
