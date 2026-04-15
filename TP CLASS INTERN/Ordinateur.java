public final class Ordinateur {

    private final String marque;
    private final String processeur;
    private final int ramGo;

    private final int stockageGo;
    private final boolean ssd;
    private final String carteGraphique;
    private final double prixEuros;

    private Ordinateur(Builder builder) {

        this.marque = builder.marque;
        this.processeur = builder.processeur;
        this.ramGo = builder.ramGo;
        this.stockageGo = builder.stockageGo;
        this.ssd = builder.ssd;
        this.carteGraphique = builder.carteGraphique;
        this.prixEuros = builder.prixEuros;
    }

    @Override
    public String toString() {

        return marque + " | "
                + processeur + " | "
                + ramGo + "Go RAM | "
                + stockageGo + "Go | "
                + carteGraphique + " | "
                + prixEuros + "€";
    }


    // classe imbriquée statique Builder
    public static class Builder {

        private String marque;
        private String processeur;
        private int ramGo;

        // valeurs par défaut
        private int stockageGo = 256;
        private boolean ssd = true;
        private String carteGraphique = "Integree";
        private double prixEuros = 0;

        public Builder(String marque, String processeur, int ramGo) {

            this.marque = marque;
            this.processeur = processeur;
            this.ramGo = ramGo;
        }

        public Builder stockageGo(int stockageGo) {

            this.stockageGo = stockageGo;
            return this; // permet d'enchaîner les méthodes
        }

        public Builder carteGraphique(String carteGraphique) {

            this.carteGraphique = carteGraphique;
            return this;
        }

        public Builder prixEuros(double prixEuros) {

            this.prixEuros = prixEuros;
            return this;
        }

        public Ordinateur build() {

            if (ramGo < 4) {

                throw new IllegalArgumentException("RAM minimum 4Go");
            }

            return new Ordinateur(this);
        }
    }


    public static void main(String[] args) {

        Ordinateur pc1 =
                new Ordinateur.Builder("Dell", "i5", 8)
                        .stockageGo(512)
                        .prixEuros(900)
                        .build();


        Ordinateur pc2 =
                new Ordinateur.Builder("Asus", "Ryzen7", 16)
                        .carteGraphique("RTX4060")
                        .prixEuros(1500)
                        .build();


        Ordinateur pc3 =
                new Ordinateur.Builder("HP", "i3", 4)
                        .build();
        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
    }