public class Paire<A, B> {

    // on stocke les 2 valeurs
    private A premier;
    private B second;

    // constructeur
    public Paire(A premier, B second) {
        this.premier = premier;
        this.second = second;
    }

    // 2 getter
    public A getPremier() { return premier; }
    public B getSecond() { return second; }

    // affichage 1 et 2 eem
    public String toString() {
        return "(" + premier + ", " + second + ")";
    }

    // methode statique qui inverse les paires valeurs 
    // on retourne une nouvelle Paire avec B en premier et A en deuxieme 
    public static <A, B> Paire<B, A> inverser(Paire<A, B> p) {
        return new Paire<>(p.getSecond(), p.getPremier());
    }
}