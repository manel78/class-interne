public class PileUtils {

    public static <T> Pile<T> inverser(Pile<T> source) {

        Pile<T> inter = new Pile<>();
        Pile<T> inverse = new Pile<>();

        //on vide source 
        // inter c inverse de source
        while (!source.estVide()) {
            inter.empiler(source.depiler());
        }

        
        // inverse contient l ordre inverse sources restar
        while (!inter.estVide()) {
            T val = inter.depiler();
            source.empiler(val);
            inverse.empiler(val);
        } // l

        return inverse;
    }
}