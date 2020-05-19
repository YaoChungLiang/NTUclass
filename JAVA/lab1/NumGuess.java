import java.util.Random;
import java.util.Scanner;
public class NumGuess{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int upperBound = 101;
        int sol = rand.nextInt(101);
        int lowerBound = 0;
        int guess = 101;
        boolean res = true;
        System.out.printf("res= %d\n", sol);
        
        while(guess != sol){
            if (guess > upperBound || guess < lowerBound){
                System.out.println("Out of range, plz reinput");
            }
            else if(guess + 1 == upperBound || guess - 1 == lowerBound){
                System.out.println("You lose");
                res = false;
                break;
            }
            else if(sol > guess){
                lowerBound =guess + 1;
            }
            else{
                upperBound = guess -1;
            }
            System.out.printf("(%d,%d)?\n", lowerBound, upperBound);
            guess = input.nextInt();
        }
        if (res){
            System.out.println("you win!");
        }
        
    }
}


class randomSearch{
    
}
