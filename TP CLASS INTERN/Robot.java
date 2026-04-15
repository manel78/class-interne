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



Question 1 (3 pts) : Pourquoi la classe interne Bras peut-elle acceder directement aux champs
prives de Robot sans getter ? Quel mecanisme Java le permet ?

la class bras peut acceder directement au attribut de robot car c'est une class interne, le mecanisme qui le permet est juste que 
classe interne peut accéder aux attributs privés de sa classe externe


Question 2 (2 pts) : Quelle est la syntaxe pour creer une instance de Bras depuis une autre
classe que Robot ? Expliquez pourquoi cette syntaxe est differente d'une instanciation classique.

Pour créer un Bras depuis une autre classe c'est ; 
Robot r = new Robot("jock", 100);
 Robot.Bras b = r.new Bras();
  le robot avant le bras car le bras dépend du robot
Question 3 (3 pts) : Si Bras avait aussi un ch
