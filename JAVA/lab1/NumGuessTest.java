import java.util.Random;
import java.util.Scanner;

// lab 1-1
public class NumGuessTest{
    public static void main(String[] args){
        // lab 1-1
        SearchNum.NumGuessHumanSearch();
        // lab 1-2
        int i = 0, randRes = 0, binRes = 0;
        while (i < 100000){
            if(SearchNum.NumGuessRandomSearch()) {
                randRes += 1;
            }
            if(SearchNum.NumGuessBinarySearch()) {
                binRes += 1;
            }            
            i += 1;
        }
        System.out.printf("winning rate of binary search = %f\n",(double) binRes/i);
        System.out.printf("winning rate of random search  = %f\n",(double) randRes/i);
    }
}

// lab 1-2
class SearchNum{
    public static void NumGuessHumanSearch(){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
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
    
    public static boolean NumGuessRandomSearch(){
        Random rand = new Random();
        int upperBound = 101;
        int sol = rand.nextInt(101);
        int lowerBound = 0;
        int guess = 101;
        boolean res = true;
        //System.out.printf("res= %d\n", sol);
        
        while(guess != sol){
            if (guess > upperBound || guess < lowerBound){
                //System.out.println("Out of range, plz reinput");
            }
            else if(guess + 1 == upperBound || guess - 1 == lowerBound){
                //System.out.println("You lose");
                return false; 
            }
            else if(sol > guess){
                lowerBound =guess + 1;
            }
            else{
                upperBound = guess -1;
            }
            //System.out.printf("(%d,%d)?\n", lowerBound, upperBound);
            guess = rand.nextInt(upperBound- lowerBound+1) + lowerBound;
        }
        if (res){
            //System.out.println("you win!");
            return true;
        }
        return false;
    }
    
    public static boolean NumGuessBinarySearch(){
        Random rand = new Random();
        int upperBound = 101;
        int sol = rand.nextInt(101);
        int lowerBound = 0;
        int guess = 101;
        boolean res = true;
        //System.out.printf("res= %d\n", sol);
        
        while(guess != sol){
            if (guess > upperBound || guess < lowerBound){
                //System.out.println("Out of range, plz reinput");
            }
            else if(guess + 1 == upperBound || guess - 1 == lowerBound){
                //System.out.println("You lose");
                return false; 
            }
            else if(sol > guess){
                lowerBound =guess + 1;
            }
            else{
                upperBound = guess -1;
            }
            //System.out.printf("(%d,%d)?\n", lowerBound, upperBound);
            guess = (int)(lowerBound + (upperBound-lowerBound)/2);
        }
        if (res){
            //System.out.println("you win!");
            return true;
        }
        return false;
    }
    /*
    public static boolean NumGuessSuperAI(){
        Random rand = new Random();
        int upperBound = 101;
        int sol = rand.nextInt(101);
        int lowerBound = 0;
        int guess = 101;
        boolean res = true;
        //System.out.printf("res= %d\n", sol);
        
        while(guess != sol){
            if (guess > upperBound || guess < lowerBound){
                //System.out.println("Out of range, plz reinput");
            }
            else if(guess + 1 == upperBound || guess - 1 == lowerBound){
                //System.out.println("You lose");
                return false; 
            }
            else if(sol > guess){
                lowerBound =guess + 1;
            }
            else{
                upperBound = guess -1;
            }
            //System.out.printf("(%d,%d)?\n", lowerBound, upperBound);
            guess = AIguess(lowerBound, upperBound);
        }
        if (res){
            //System.out.println("you win!");
            return true;
        }
        return false;
    }

    public static int AIguess(){
        return 3;
    }
    */
}


