import java.util.*;

public class Cashier{
    public static void main(String[] args){
        int total = 0, price = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter price?");
        price = input.nextInt();

        do {
            total += price;
            System.out.println("Enter price?");
            price = input.nextInt();
        } while (price > 0);
        System.out.println("Total = " + total);

    }
}


