import java.util.*;

public class Stats<T extends Number> {

    private List<T> valeurs;

    public Stats(List<T> valeurs) {
        this.valeurs = valeurs;
    }

    public double moyenne() {
        double total = 0;
        for (T n : valeurs) {
            total += n.doubleValue();
        }
        return total / valeurs.size();
    }

    public T min() {
        T minimum = valeurs.get(0);
        for (T n : valeurs) {
            if (n.doubleValue() < minimum.doubleValue()) {
                minimum = n;
            }
        }
        return minimum;
    }

    public T max() {
        T maximum = valeurs.get(0);
        for (T n : valeurs) {
            if (n.doubleValue() > maximum.doubleValue()) {
                maximum = n;
            }
        }
        return maximum;
    }

    public double ecartType() {
        double moy = moyenne();
        double sommeCarres = 0;
        for (T n : valeurs) {
            double diff = n.doubleValue() - moy;
            sommeCarres += diff * diff;
        }
        return Math.sqrt(sommeCarres / valeurs.size());
    }

    public static <T extends Number> double somme(List<T> liste) {
        double total = 0;
        for (T n : liste) {
            total += n.doubleValue();
        }
        return total;
    }
}