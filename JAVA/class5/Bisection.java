public class Bisection{
    public static void main(String[] args){
        double a=1, b=2, c=0, eps=1e-9;
        double fa,fb,fc;
        while(b-a > eps){
            c = (a+b)/2;
            fa = f(a); 
            fb = f(b); 
            fc = f(c);
            if(fa*fc<0){
                b = c;
            }
            else{
                a = c;
            }
        }
        System.out.printf("root = %f\n", c);
        System.out.printf("residual = %6.3e\n", c*c*c-c-2);

        
    }
    static double f(double a){
        return a*a*a-a-2;
    }
}
