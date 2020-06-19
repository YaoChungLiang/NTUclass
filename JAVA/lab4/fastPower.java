import java.lang.Math;
import java.math.BigDecimal;

public class fastPower{
    public static void main(String[] args){
        BigDecimal res;
        int n;
        BigDecimal x = new BigDecimal(2);
        long st,recurDur, naiveDur;
        System.out.printf("%4s%2s%10s%19s%9s\n","x","^","n","|","Speedup");
        for(int i= 0; i <6;i++){
            n = (int) Math.pow(10 ,i);
            st = System.nanoTime();
            res = powerRecur(x,n);
            recurDur = System.nanoTime() - st;

            st = System.nanoTime();
            res = powerNaive(x,n);
            naiveDur = System.nanoTime() - st;

            System.out.printf("%1.2f%2s%10d%2s %6.6e%4s%4d\n",x,"^",n,"=",res,"|",naiveDur/recurDur);
        }
    }

    static BigDecimal powerNaive(BigDecimal x, int n){
        BigDecimal tmp = new BigDecimal(1);
        tmp = tmp.multiply(x);
            for(int i=0;i<n;i++){
        }
        return tmp;
    }

    static BigDecimal powerRecur(BigDecimal x, int n){
        if(n==0) return new BigDecimal(1);
        if(n==1) return x;
        if(n%2 == 0) return powerRecur(x.multiply(x), n/2);
        else return powerRecur(x.multiply(x),n/2).multiply(x);
    }

    String multiplyString(String str, int count){ 
        StringBuilder sb = new StringBuilder(); 
        for( int i = 0; i < count; ++i ){ 
            sb.append(str);
        }
        return sb.toString(); 
    }
}
