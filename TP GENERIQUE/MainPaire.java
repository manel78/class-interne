public class MainPaire {
    public static void main(String[] args) {

        // integer avec paire de string 
        Paire<String, Integer> p1 = new Paire<>("Alice", 42);
        System.out.println(p1); // (Alice, 42)

        // on inverse
        Paire<Integer, String> p2 = Paire.inverser(p1);
        System.out.println(p2); // (42, Alice)

        // Paire double et boolean 
        Paire<Double, Boolean> p3 = new Paire<>(3.14, true);
        // getSimpleName retourne le nom simple de la classe de l'objet
        System.out.println(p3.getPremier().getClass().getSimpleName()
            + " — " + p3.getSecond().getClass().getSimpleName());
        // affiche Double puis Boolean
    }
}