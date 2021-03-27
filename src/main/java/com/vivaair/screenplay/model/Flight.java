package com.vivaair.screenplay.model;

import org.openqa.selenium.Keys;

public class Flight {
    private final String originStr;
    private final String destinationStr;

    public Flight(String originStr, String destinationStr) {
        this.originStr = originStr + Keys.ENTER;
        this.destinationStr = destinationStr + Keys.ENTER;
    }

    public String getOriginStr() {
        return originStr;
    }

    public String getDestinationStr() {
        return destinationStr;
    }
}
