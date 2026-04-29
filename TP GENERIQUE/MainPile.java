public class MainPile {
    public static void main(String[] args) {

        Pile<Integer> pile = new Pile<>();

        pile.empiler(1);
        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(4);
        pile.empiler(5);

        System.out.println("Pile : " + pile); // [5 / 4 / 3 / 2 / 1]

        int valeur = pile.depiler();
        System.out.println("Valeur depilee : " + valeur); // 5
        System.out.println("Pile apres depilage : " + pile); // [4 / 3 / 2 / 1]

        Pile<Integer> pileInversee = PileUtils.inverser(pile);
        System.out.println("Pile originale : " + pile);        // [4 / 3 / 2 / 1]
        System.out.println("Pile inversee : " + pileInversee); // [1 / 2 / 3 / 4]
    }
}