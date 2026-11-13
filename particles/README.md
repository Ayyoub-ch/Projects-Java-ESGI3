# Projects-Java-ESGI3
Projets Java Effectués lors du TP du 13 novembre 2026

/model:

    - Particle : Représente une particule individuelle au sein de la simulation. Elle gère ses coordonnées spatiales (x, y), son rayon (radius), ses composantes de vitesse (vx, vy) ainsi que sa couleur (Color). Elle intègre également une méthode move() pour actualiser sa position en fonction de sa vitesse.

    - Color : Gère la représentation des couleurs au format RVB (Rouge, Vert, Bleu) avec des valeurs comprises entre 0 et 255 grâce à une méthode de limitation (clamp). Elle permet aussi de générer une couleur aléatoire via une méthode statique dédiée.

    - Simulation : Coordonne l'environnement global de la simulation en définissant ses dimensions (width, height) et en stockant la liste dynamique des particules (ArrayList<Particle>) qui y évoluent.


    - Main : Lance le programme et accorde les différentes parties.






Note pour le professeur : Désolé si cela est vide, je n'ai pas réussi à faire mieux, je n'ai que quelques bases en Java (Ant), j'ai essayé de faire au moins le premier projet, mais le reste non.
