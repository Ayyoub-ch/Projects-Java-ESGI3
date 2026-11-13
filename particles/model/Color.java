package com.example.model;

import java.util.Random;

public class Color {

    // Attributes

    private int red;
    private int green;
    private int blue;

    // Constructor
    public Color (int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    // Generate a Random Color
    public static Color random () {
        Random rand = new Random();
        return new Color(
            rand.nextInt(256), 
            rand.nextInt(256), 
            rand.nextInt(256)
        );
    }

    // Getters

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    // Setters

    public void setRed(int red) {
        this.red = clamp(red);
    }

    public void setGreen(int green) {
        this.green = clamp(green);
    }

    public void setBlue(int blue) {
        this.blue = clamp(blue);
    }

    // Avoid invalid color value between 0 and 255

    private int clamp(int value) {
        if (value < 0) return 0;
        if (value > 255) return 255;
        return value;
    }


}
