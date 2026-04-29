import java.util.*;

public class MainStats {
    public static void main(String[] args) {

        List<Integer> entiers = Arrays.asList(10, 20, 30, 40, 50);
        Stats<Integer> stats = new Stats<>(entiers);

        System.out.println("Moyenne : " + stats.moyenne());
        System.out.println("Min : " + stats.min());
        System.out.println("Max : " + stats.max());
        System.out.println("Ecart type : " + stats.ecartType());
        System.out.println("Somme : " + Stats.somme(entiers));

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        Stats<Double> stats2 = new Stats<>(doubles);
        System.out.println("Moyenne doubles : " + stats2.moyenne());

        // erreur :  new Stats<>(new ArrayList<>());
        // ca ne compile ps
    }
}