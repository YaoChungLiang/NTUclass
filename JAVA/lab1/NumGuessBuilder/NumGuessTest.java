import java.util.Random;
import java.util.Scanner;

// lab 1
public class NumGuessTest{
    public static void main(String[] args){
        boolean humanRes, randomRes, binaryRes;
        int binRes = 0, randRes = 0;
        // lab 1-1 human search a
        NGBuilder HumanSearch = new NGBuilder().setStrategy("human");
        if(args.length == 3 || args.length == 2)
            HumanSearch.setBounds(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        humanRes = HumanSearch.NumGuess();  
        // lab 1-2 search algo without iteration limit
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
        // lab 1-3 search algo with max Iteration
        int maxIter = 7;
        if(args.length == 3)
            maxIter = Integer.parseInt(args[2]);
        NGBuilder RandomSearchIter = new NGBuilder().setStrategy("random").setIter(maxIter);
        NGBuilder BinarySearchIter = new NGBuilder().setStrategy("binary").setIter(maxIter);
        if(args.length == 3 || args.length == 2){
            RandomSearchIter.setBounds(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            BinarySearchIter.setBounds(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
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


class NGBuilder{
    private int iter;
    private String strategy;
    int lowBound;
    int upBound;

    public NGBuilder setIter(int iter){
        this.iter = iter;
        return this;
    }

    public NGBuilder setStrategy(String strategy){
        this.strategy = strategy;
        return this;
    }

    public NGBuilder setBounds(int low, int up){
        this.lowBound = low;
        this.upBound = up;
        return this;
    }

    public boolean NumGuess(){
        Random rand = new Random();
        int upperBound = (this.upBound != 0 ? upBound+1 : 100);
        int sol = rand.nextInt(upperBound+1);
        int lowerBound = (this.lowBound != 0 ? lowBound : 0);
        
        if(upperBound < lowerBound+2){
            System.out.println("Invalid Bound values : UpperBound is equal to lowerBound");
            System.exit(0);
        }
        int guess = upperBound;
        boolean res = true;
        Scanner input = new Scanner(System.in);
        int iter = this.iter;
        
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


