package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Color;
import com.example.model.Particle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Random random = new Random();

        // 1. Récupérer la taille de l'écran pour le mode plein écran
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double width = screenBounds.getWidth();
        double height = screenBounds.getHeight();

        // 2. Créer les listes pour relier le modèle et la vue
        List<Particle> particles = new ArrayList<>();
        List<Circle> fxCircles = new ArrayList<>();

        int particleCount = 30;

        for (int i = 0; i < particleCount; i++) {
            double radius = 15 + random.nextInt(25);
            double x = radius + random.nextDouble() * (width - 2 * radius);
            double y = radius + random.nextDouble() * (height - 2 * radius);

            // Calculer vx et vy aléatoires (direction et sens) avant de créer la particule
            double speed = 2.0 + random.nextDouble() * 4.0;
            double angle = random.nextDouble() * 2 * Math.PI;
            double vx = Math.cos(angle) * speed;
            double vy = Math.sin(angle) * speed;

            Color modelColor = Color.random();

            // Création de l'objet avec vos 6 paramètres (x, y, radius, vx, vy, color)
            Particle particle = new Particle(x, y, radius, vx, vy, modelColor);
            particles.add(particle);

            // Création du cercle graphique JavaFX correspondant
            Circle circle = new Circle(x, y, radius);
            circle.setFill(javafx.scene.paint.Color.rgb(
                modelColor.getRed(),
                modelColor.getGreen(),
                modelColor.getBlue()
            ));

            fxCircles.add(circle);
            root.getChildren().add(circle);
        }

        // 3. Boucle d'animation (60 images par seconde)
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < particles.size(); i++) {
                    Particle p = particles.get(i);
                    Circle c = fxCircles.get(i);

                    // Avancer la particule dans le modèle
                    p.move();

                    // Rebonds sur les bords gauche et droit
                    if (p.getX() - p.getRadius() <= 0) {
                        p.setX(p.getRadius());
                        p.setVx(-p.getVx());
                    } else if (p.getX() + p.getRadius() >= width) {
                        p.setX(width - p.getRadius());
                        p.setVx(-p.getVx());
                    }

                    // Rebonds sur les bords haut et bas
                    if (p.getY() - p.getRadius() <= 0) {
                        p.setY(p.getRadius());
                        p.setVy(-p.getVy());
                    } else if (p.getY() + p.getRadius() >= height) {
                        p.setY(height - p.getRadius());
                        p.setVy(-p.getVy());
                    }

                    // Mettre à jour la position graphique du cercle
                    c.setCenterX(p.getX());
                    c.setCenterY(p.getY());
                }
            }
        };
        timer.start();

        // 4. Configurer et afficher la fenêtre en plein écran
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Particle Simulation");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
