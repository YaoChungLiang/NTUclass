// private doesn't help protect your data
import java.util.Arrays;
public class Reflec{
    public static void main(String[] args) throws Illegal
    
    {
        // field
        Poker card = new Poker(Suit.Spade, Rank.two);
        Class<?> clz = card.getClass();
        List<Field> fields = Arrays.asList(clz.getDeclaredFields());
        fields.forEach(System.out::println);
        Field suit = fields.get(0);
        suit.setAccessible(True);
        suit.set(card, Suit.club);
        Field rank = fields.get(1);
        rank.setAccessible(True);
        rank.set(card, rank.three);
        System.out.println(card);

        // method
        List<Method> methods = Array.asList(clz.getDeclaredMethods());
        methods.forEach(System.out::println);
        System.out.println(methods.get(4).invoke(card));

        // constructor
        List<Constructor> constructor = Array.asList(clz.getDeclaredMethods());
        Poker new_card = (Poker)  constructors.get(0).newInstance(Suit.Spade. Rank.two);
        // array
        int[] A = new int[3];
        System.out.println(A.getCalss().getName());
       
    }
}


