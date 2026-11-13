package com.example.model;

import java.util.ArrayList;

public class Simulation {

    // Attributes
    private int width;
    private int height;
    private ArrayList<Particle> particles;

    // Constructor
    public Simulation (int width, int height) {
        this.width = width;
        this.height = height;
        this.particles = new ArrayList<>();
    }

    // Getters

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    
    // Setters

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
