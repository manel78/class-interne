public class Robot {

    private String nom;
    private boolean allume = false;
    private int energie;

    public Robot(String nom, int energie) {
        this.nom = nom;
        this.energie = energie;
    }

    public void allumer() {
        allume = true;
        System.out.println("Robot allumé");
    }

    public void eteindre() {
        allume = false;
        System.out.println("Robot éteint");
    }

    public Bras getBras() {
        return new Bras();
    }

    // classe interne en deuxieme 
    class Bras {

        public void saisir(String objet) {

            if (!allume) {
                System.out.println("Impossible, robot éteint");
            }
            else if (energie > 20) {
                System.out.println(nom + " saisit " + objet);
                energie -= 10;
            }
            else {
                System.out.println("Pas assez d'énergie");
            }
        }

        public void deposer(String objet) {

            if (allume) {
                System.out.println(nom + " dépose " + objet);
                energie -= 5;
            }
            else {
                System.out.println("Robot éteint");
            }
        }

        public void afficherEtat() {

            System.out.println("Nom : " + nom);
            System.out.println("Allumé : " + allume);
            System.out.println("Energie : " + energie);
        }
    }

    public static void main(String[] args) {

        Robot r = new Robot("R2D2", 50);

        Bras bras = r.getBras();

        bras.saisir("boite"); //marche pas robot éteint

        r.allumer();

        bras.saisir("boite");
        bras.deposer("boite");

        bras.afficherEtat();

        r.eteindre();
    }