import java.util.*;

class Produit {
    String nom;
    String categorie;
    double prix;
    int quantite;
    // 

    public Produit(String nom, String categorie, double prix, int quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String toString() {
        return nom + " | " + categorie + " | " + prix + " euros | qte : " + quantite;
    }
}

public class GestionnaireStock {
    private List<Produit> stock = new ArrayList<>();

    public void ajouter(Produit p) {
        stock.add(p);
    }

    public List<Produit> filtrerEtTrier(String categorie, double prixMax, int quantiteMin) {

        // locale 
        interface Filtre {
            boolean accepter(Produit p);
        }

        // elle est locale et elle applique le filtre en plus 
        class FiltreCompose implements Filtre {
            public boolean accepter(Produit p) {
                return p.categorie.equals(categorie)
                    && p.prix <= prixMax
                    && p.quantite >= quantiteMin;
            }
        }

        Filtre monFiltre = new FiltreCompose();
        List<Produit> resultat = new ArrayList<>();

        for (Produit p : stock) {
            if (monFiltre.accepter(p)) {
                resultat.add(p);
            }
        }

        // trier en croissant 
        resultat.sort(Comparator.comparingDouble(p -> p.prix));
        return resultat;
    }

    public static void main(String[] args) {
        GestionnaireStock g = new GestionnaireStock();

        g.ajouter(new Produit("Stylo", "Papeterie", 1.5, 50));
        g.ajouter(new Produit("Cahier", "Papeterie", 3.0, 20));
        g.ajouter(new Produit("Classeur", "Papeterie", 5.0, 5));
        g.ajouter(new Produit("Souris", "Informatique", 25.0, 15));
        g.ajouter(new Produit("Clavier", "Informatique", 45.0, 8));
        g.ajouter(new Produit("Ecran", "Informatique", 199.0, 3));
        g.ajouter(new Produit("Crayon", "Papeterie", 0.8, 100));
        g.ajouter(new Produit("Webcam", "Informatique", 60.0, 12));

        System.out.println("--- Papeterie moins de 4 euros ---");
        System.out.println(g.filtrerEtTrier("Papeterie", 4.0, 10));

        System.out.println("--- Informatique moins de 50 euros ---");
        System.out.println(g.filtrerEtTrier("Informatique", 50.0, 10));
    }
}


// Q1 la classe java ne laisse pas ( p.categorie.equals(categorie) && p.prix <= prixMax && p.quantite >= quantiteMin;) se modifie pas car lors de la creation elle les enregistre et si ca cahnge elle aurais des valeurs bizarres/ ambigues.
// Q2 public List<Produit> filtrerEtTrierStream(String categorie, double prixMax, int quantiteMin) {
   //  return stock.stream()
   //      .filter(p -> p.categorie.equals(categorie))
   //      .filter(p -> p.prix <= prixMax)
   //     .filter(p -> p.quantite >= quantiteMin)
   //     .sorted(Comparator.comparingDouble(p -> p.prix))
   //     .collect(java.util.stream.Collectors.toList());
   // bcp plus cours et lisible pour la version stream 