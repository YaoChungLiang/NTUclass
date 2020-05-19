import java.lang.Enum;









public enum Strategy{
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
        return this
    }
}



