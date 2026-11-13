package com.example.model;

import java.util.Random;

public class Particle {


    // Attributes

    private double x;
    private double y;
    private double radius;
    private double vx;
    private double vy;
    private Color color;
    Random rand = new Random();

    // Constructor
    public Particle(double x, double y, double radius, double vx, double vy, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = Math.cos(rand.nextInt(360));
        this.vy = Math.sin(rand.nextInt(360));
        this.color = color;
    }

    // Move method : add speed to particles
    public void move () {
        this.x+= this.vx;
        this.y += this.vy;
    }

    // Getters

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getVx() {
        return this.vx;
    }

    public double getVy() {
        return this.vy;
    }

    public double getRadius() {
        return this.radius;
    }

    public Color getColor() {
        return this.color;
    }

    // Setters

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
