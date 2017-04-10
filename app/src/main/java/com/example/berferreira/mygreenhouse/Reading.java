package com.example.berferreira.mygreenhouse;

/**
 * Created by berferreira on 06-04-2017.
 */

public class Reading {

    String temperature;
    String humidity;

    public Reading() {
    }

    public Reading(String temperature, String humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
