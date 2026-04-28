E1.Q1/ une classe interne fait partie dela classe externe donc elle voit ses champs privés direct sans get 
Q2/ Robot r = new Robot("Rob", 100);
Robot.Bras b = r.new Bras();
Bras ne peut pas exister sans un Robot
Q3/ class Bras {
    int energie = 50;
    void exemple() {
        System.out.println(energie);           
        System.out.println(Robot.this.energie); 
    }
E2.Q1/ le builder est static parce que il est avant ordinateur avant qu'il existe et si il est pas staic on doit le creer avant pour apres crerr un builder.
Q2/ c'est quand o empile des constructeurs pour chaque possibilite : ex : public Ordinateur(String marque, String processeur, int ram) ainsi de suite ..
Q3/ liste qui bloque les modifs (Collections.UnmodifiableList) et (Map.Entry(avec leurs valeurs))
