import java.util.Scanner;
public class AreaDemo{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter an r value");
        int r = input.nextInt();
        double A = r*r*3.14;
        System.out.println(A);
        input.close(); 
    }
}
