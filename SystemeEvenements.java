import java.util.*; 
// ca veut dire que cette interface elle a que une seule  abstraite pour @FunctionalInterface c tt 
// et ca permet de l'utiliser avec un lambda plus tard
@FunctionalInterface
interface ClickListener {
    void onClick(int x, int y);
}

@FunctionalInterface
interface KeyListener {
    // methode appelee  comme getchar 
    void onKeyPress(char touche);
}
@FunctionalInterface
interface HoverListener {
    // methode appelee quand la souris entre ou sort du bouton
    // entre = true si la souris arrive, false si elle part
    void onHover(boolean entre);
}

class Bouton {
    
    // le texte affiche sur le bouton
    String label;
    
    // on stocke tous les listeners dans des listes
    // comme ca on peut en ajouter autant qu'on veut
    List<ClickListener> clickListeners = new ArrayList<>();
    List<KeyListener> keyListeners = new ArrayList<>();
    List<HoverListener> hoverListeners = new ArrayList<>();

    // constructeur : on cree un bouton avec son label
    public Bouton(String label) {
        this.label = label;
    }

    // ces methodes permettent d'ajouter un listener a la liste correspondante
    public void addClickListener(ClickListener l) { 
        clickListeners.add(l); 
    }
    public void addKeyListener(KeyListener l) { 
        keyListeners.add(l); 
    }
    public void addHoverListener(HoverListener l) { 
        hoverListeners.add(l); 
    }

    // simule un clic sur le bouton
    // on parcourt tous les clickListeners et on appelle onClick sur chacun
    public void simulerClic(int x, int y) {
        for (ClickListener l : clickListeners) {
            l.onClick(x, y);
        }
    }

    // simule l'appui sur une touche
    // on parcourt tous les keyListeners et on appelle onKeyPress sur chacun
    public void simulerTouche(char c) {
        for (KeyListener l : keyListeners) {
            l.onKeyPress(c);
        }
    }

    // simule le survol du bouton
    // entre = true si la souris entre, false si elle sort
    public void simulerSurvol(boolean entre) {
        for (HoverListener l : hoverListeners) {
            l.onHover(entre);
        }
    }
}

public class SystemeEvenements {

    public static void main(String[] args) {
        
        // on cree un bouton "Valider"
        Bouton btn = new Bouton("Valider");
        
        // tableau de taille 1 pour stocker le compteur
        // on utilise un tableau et pas un int simple parce que
        // les classes anonymes ne peuvent pas modifier une variable locale directement
        // (elle doit etre "effectivement finale")
        final int[] compteur = {0};

        // ── CLICKLISTENER 1 ──────────────────────────────────────
        // classe anonyme qui implemente ClickListener
        // elle affiche juste les coordonnees du clic
        btn.addClickListener(new ClickListener() {
            // on est oblige de redefinir onClick car c'est la methode de l'interface
            public void onClick(int x, int y) {
                System.out.println("Clic detecte a la position (" + x + ", " + y + ")");
            }
        });

        // ── CLICKLISTENER 2 ──────────────────────────────────────
        // deuxieme classe anonyme pour le meme type de listener
        // cette fois elle incremente le compteur a chaque clic
        // on peut avoir plusieurs listeners du meme type, ils sont tous appeles
        btn.addClickListener(new ClickListener() {
            public void onClick(int x, int y) {
                // on incremente compteur[0] et on affiche la valeur
                compteur[0]++;
                System.out.println("Nombre total de clics : " + compteur[0]);
            }
        });

        // ── KEYLISTENER ───────────────────────────────────────────
        // classe anonyme qui implemente KeyListener
        // elle dit si la touche tapee est une voyelle ou une consonne
        btn.addKeyListener(new KeyListener() {
            public void onKeyPress(char c) {
                // on regarde si le caractere est dans la chaine des voyelles
                // indexOf renvoie -1 si le caractere n'est pas trouve
                if ("aeiouyAEIOUY".indexOf(c) >= 0) {
                    System.out.println("La touche '" + c + "' est une voyelle");
                } else {
                    System.out.println("La touche '" + c + "' est une consonne");
                }
            }
        });

        // ── HOVERLISTENER ─────────────────────────────────────────
        // classe anonyme qui implemente HoverListener
        // elle affiche une info-bulle quand la souris survole le bouton
        btn.addHoverListener(new HoverListener() {
            public void onHover(boolean entre) {
                // si entre = true la souris arrive sur le bouton
                if (entre) {
                    System.out.println("[Info-bulle] Cliquez pour valider le formulaire");
                } else {
                    // si entre = false la souris quitte le bouton
                    System.out.println("[Info-bulle fermee]");
                }
            }
        });

        // ── SIMULATION DES INTERACTIONS ───────────────────────────
        
        // simule deux clics : les DEUX clickListeners vont etre appeles a chaque fois
        btn.simulerClic(100, 200);
        btn.simulerClic(150, 250);
        
        // simule l'appui sur 'a' (voyelle) puis 'z' (consonne)
        btn.simulerTouche('a');
        btn.simulerTouche('z');
        
        // simule la souris qui entre puis qui sort du bouton
        btn.simulerSurvol(true);
        btn.simulerSurvol(false);
    }

    // ── VERSION LAMBDA ────────────────────────────────────────────
    // exactement la meme chose qu'au dessus mais en beaucoup plus court
    // un lambda remplace toute la classe anonyme en une seule ligne
    // possible uniquement parce que les interfaces sont @FunctionalInterface
    public static void mainLambda(String[] args) {
        Bouton btn = new Bouton("Valider");
        final int[] compteur = {0};

        // (x, y) -> ... remplace new ClickListener() { public void onClick(int x, int y) { ... } }
        btn.addClickListener((x, y) -> System.out.println("Clic a (" + x + ", " + y + ")"));
        
        // ++compteur[0] incremente avant d'afficher
        btn.addClickListener((x, y) -> System.out.println("Clics : " + (++compteur[0])));
        
        // operateur ternaire ? : pour ecrire le if/else en une ligne
        btn.addKeyListener(c -> System.out.println(c + " : " + 
            ("aeiouyAEIOUY".indexOf(c) >= 0 ? "voyelle" : "consonne")));
        
        // e = true ou false selon si la souris entre ou sort
        btn.addHoverListener(e -> System.out.println(
            e ? "Info-bulle ouverte" : "Info-bulle fermee"));

        btn.simulerClic(100, 200);
        btn.simulerTouche('e');
        btn.simulerSurvol(true);
    }
}

// Q1: la function interface n'est pas obligatoire mais elle est utile. elle dit au compilateur l interface doit avoir 1 methode abstraite pas plus.
// si y en a deux ona direct une erreur de compilation 
/* Q2 // Cas 1 : interface avec 2 methodes -> lambda impossible
// un lambda ne peut faire qu'une seule chose
// ici il faudrait deux methodes donc classe anonyme obligatoire
new MonListener() {
    public void onStart() { 
        System.out.println("debut"); 
    }
    public void onEnd() { 
        System.out.println("fin"); 
    }
}

// Cas 2 : besoin de garder un etat entre les appels -> lambda impossible
// un lambda ne peut pas avoir de champ propre
// ici nbClics doit se souvenir de sa valeur entre chaque clic
new ClickListener() {
    int nbClics = 0; // champ propre a cette classe anonyme
    public void onClick(int x, int y) {
        nbClics++;
        System.out.println("Total depuis le debut : " + nbClics);
    }
} */
