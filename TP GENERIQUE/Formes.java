import java.util.*;

abstract class Forme {
    abstract double surface();
}

class Cercle extends Forme {
    double rayon;
    Cercle(double r) { this.rayon = r; }
    public double surface() { return Math.PI * rayon * rayon; }
    public String toString() { return "Cercle(r=" + rayon + ")"; }
}

class Rectangle extends Forme {
    double largeur, hauteur;
    Rectangle(double l, double h) { largeur = l; hauteur = h; }
    public double surface() { return largeur * hauteur; }
    public String toString() { return "Rectangle(" + largeur + "x" + hauteur + ")"; }
}

public class Formes {

    // List<?> accepte n importe quelle liste
    // on ne peut que lire les elements, pas en ajouter
    public static void afficherSurfaces(List<?> formes) {
        for (Object f : formes) {
            System.out.println(f + " -> surface : " + ((Forme) f).surface());
        }
    }

    // List<? extends Forme> accepte List<Cercle>, List<Rectangle>, List<Forme>
    // si on mettait List<Forme> on ne pourrait pas passer une List<Cercle>
    public static double sommerSurfaces(List<? extends Forme> formes) {
        double total = 0;
        for (Forme f : formes) {
            total += f.surface();
        }
        return total;
    }

    // List<? super Cercle> accepte List<Cercle>, List<Forme>, List<Object>
    // on peut ajouter des Cercle dedans
    public static void remplirCercles(List<? super Cercle> destination, int n) {
        for (int i = 0; i < n; i++) {
            destination.add(new Cercle(1.0));
        }
    }

    // source on lit dedans -> ? extends T
    // destination on ecrit dedans -> ? super T
    // c est la regle PECS : Producer Extends Consumer Super
    public static <T extends Forme> void copier(
            List<? extends T> source,
            List<? super T> destination) {
        for (T element : source) {
            destination.add(element);
        }
        // si on essaie source.add(...) -> erreur de compilation
        // car source est en lecture seule (extends)
    }

    public static void main(String[] args) {

        List<Cercle> cercles = Arrays.asList(new Cercle(2.0), new Cercle(3.0));
        List<Rectangle> rectangles = Arrays.asList(new Rectangle(4.0, 5.0));

        // Q4.1
        afficherSurfaces(cercles);
        afficherSurfaces(rectangles);

        // Q4.2
        System.out.println("Somme cercles : " + sommerSurfaces(cercles));
        System.out.println("Somme rectangles : " + sommerSurfaces(rectangles));

        // Q4.3
        List<Forme> formes = new ArrayList<>();
        remplirCercles(formes, 3);
        System.out.println("Nb formes : " + formes.size()); // 3

        // Q4.4
        List<Cercle> source = new ArrayList<>(Arrays.asList(new Cercle(1.0), new Cercle(2.0)));
        List<Forme> destination = new ArrayList<>();
        copier(source, destination);
        System.out.println("Elements copies : " + destination.size()); // 2
    }
}