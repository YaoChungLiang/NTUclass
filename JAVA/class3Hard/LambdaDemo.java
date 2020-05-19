public class LambdaDemo{
    public static void main(String[] args){
        Operator adder = new Operator(){
            @Override
            public int compute(int x, int y){
                return x+y;
            }
        };
        System.out.println(adder.compute(10,20));

        Operator multiplier = (x,y) -> x*y;
        System.out.println(multiplier.compute(10,20));
    }
}

// better for only one function in interface
@FunctionalInterface
interface Operator{
    int compute(int x, int y);
}



