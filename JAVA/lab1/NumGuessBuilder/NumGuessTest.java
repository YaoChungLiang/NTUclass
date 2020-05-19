import java.util.Random;
import java.util.Scanner;

// lab 1
public class NumGuessTest{
    public static void main(String[] args){
        boolean humanRes, randomRes, binaryRes;
        int binRes = 0, randRes = 0;
        // lab 1-1
        NGBuilder HumanSearch = new NGBuilder().setStrategy("human");
        humanRes = HumanSearch.NumGuess();  
        // lab 1-2
        NGBuilder RandomSearch = new NGBuilder().setStrategy("random");
        NGBuilder BinarySearch = new NGBuilder().setStrategy("binary");
        int total = (int) 1e5;
        for(int i = 0; i< total ; i++){
            if(RandomSearch.NumGuess()){
                randRes += 1;
            }
            if(BinarySearch.NumGuess()){
                binRes += 1;
            }
        }
        System.out.printf("winning rate of binary search = %f\n",(double) binRes/total);
        System.out.printf("winning rate of random search  = %f\n",(double) randRes/total);
        // lab 1-3 
        int maxIter = 7;
        NGBuilder RandomSearchIter = new NGBuilder().setStrategy("random").setIter(maxIter);
        NGBuilder BinarySearchIter = new NGBuilder().setStrategy("binary").setIter(maxIter);
        randRes = 0;
        binRes = 0;
        for(int i = 0; i< total ; i++){
            if(RandomSearchIter.NumGuess()){
                randRes += 1;
            }
            if(BinarySearchIter.NumGuess()){
                binRes += 1;
            }
            
        }
        System.out.printf("winning rate of binary search with iteration of %d = %f\n", maxIter ,(double) binRes/total);
        System.out.printf("winning rate of random search with iteration of %d = %f\n", maxIter ,(double) randRes/total);
    }
}


enum Strategy{
    human, binary, random
}

class NGBuilder{
    private int iter;
    private String strategy;
    
    public NGBuilder setIter(int iter){
        this.iter = iter;
        return this;
    }

    public NGBuilder setStrategy(String stra){
        this.strategy = stra;
        return this;
    }

    public boolean NumGuess(){
        Random rand = new Random();
        int upperBound = 101;
        int sol = rand.nextInt(101);
        int lowerBound = 0;
        int guess = 101;
        boolean res = true;
        Scanner input = new Scanner(System.in);
        int iter = this.iter;
        //String strategy = this.strategy;
        //System.out.printf("res= %d\n", sol);
        
        while(guess != sol){
            if (iter != 0){
                iter -= 1;
                if(iter == 0){
                    if(this.strategy == "human"){
                        System.out.println("You lose");
                    }
                    return false;
                }
            }
            if (this.strategy == "human" && (guess > upperBound || guess < lowerBound) ){
                System.out.println("Out of range, plz reinput");
            }
            else if(sol == upperBound && guess + 1 == sol){
                if(this.strategy == "human"){
                    System.out.println("You lose");
                }
                return false;
            }
            else if(sol == lowerBound && guess -1 == sol){
                if(this.strategy == "human"){
                    System.out.println("You lose");
                }
                return false;
                
            }
            else if(sol > guess){
                lowerBound = guess + 1;
            }
            else{
                upperBound = guess - 1;
            }
            
            if(this.strategy == "human"){
                System.out.printf("(%d,%d)?\n", lowerBound, upperBound);
                guess = input.nextInt();
            }
            else if(this.strategy == "binary"){
                guess = (int)(lowerBound + (upperBound-lowerBound)/2);
            }
            else if(this.strategy == "random"){
                guess = rand.nextInt(upperBound- lowerBound+1) + lowerBound;
            }
            else{
                System.out.println(" Plz specify corresponding strategy");
                break;
            }
        }
        if(this.strategy == "human"){
            System.out.println("You win");
        }        
        
        return true;

    }
}


