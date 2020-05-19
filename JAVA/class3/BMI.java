import java.util.Scanner;
public class BMI{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter an height value/m"); 
        double h= input.nextDouble();
        System.out.println("Enter an weight value/kg");
        double w = input.nextDouble();    
        double bmi = 10000*w/h/h;

        System.out.println(bmi);
        input.close(); 
    }
}
