import java.util.Random;
import java.util.Scanner;
public class Arith{
    public static void main(String[] args){
        /*
        Random rand = new Random();
        int j = rand.nextInt(11);
        */
        int x = (int) (Math.random()*10);
        int y = (int) (Math.random()*10);

        System.out.println("x+y=?");
        Scanner input = new Scanner(System.in);
        int g = input.nextInt();
        if (g==x+y){
            System.out.println("Correct.");
        }
        else{
            System.out.println("Wrong.");
            System.out.println("It is "+(x+y)+" .");
        }
    }
}
