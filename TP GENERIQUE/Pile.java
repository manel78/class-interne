import java.util.*;

public class Pile<T> {

    // stocker tout les elments avec ArrayList
    // trier le derniere element de la liste 
    private List<T> elements = new ArrayList<>();

    // + un element en haut de la list
    public void empiler(T element) {
        elements.add(element);
    }

    // retourne et retire le sommet 
    // si la pile est vide alors on a un retour 
    public T depiler() {
        if (estVide()) {
            throw new NoSuchElementException("La pile est vide !");
        }
        // retirer le derniere element de la liste 
        return elements.remove(elements.size() - 1);
    }

    // lit le sommet sans le retirer //  ça arrête tout et envoie une erreur 
    public T sommet() {
        if (estVide()) {
            throw new NoSuchElementException("La pile est vide !");
        }
        return elements.get(elements.size() - 1);
    }

    // renvoie true si vide 
    public boolean estVide() {
        return elements.isEmpty();
    }

    // renvoie le nombre 
    public int taille() {
        return elements.size();
    }

    // affiche la pile du sommet vers la base
    public String toString() {
        String resultat = "[";
        for (int i = elements.size() - 1; i >= 0; i--) {
            resultat += elements.get(i);
            if (i > 0) resultat += " | ";
        }
        return resultat + "]";
    }
}