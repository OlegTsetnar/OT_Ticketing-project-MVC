package com.cydeo.enums;

public enum Status {

  OPEN("Open"), IN_PROGRESS("InProgress"), COMPLETE ("Completed");


  private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
