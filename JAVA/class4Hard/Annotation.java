
        @RequestForEnhancement(date = "2020/05/17",
                                id = 3;
                                synopsis = "what")

public class Annotation{
        @RequestForEnhancement(date = "2020/05/17",
                                id = 3;
                                synopsis = "what")
    public static void main(String[] args){

    }
}

@interface RequestForEnhancement{
    int id();
    String synopsis();
    String engineer() default "unassigned";
    String date() default "inassigned";

}
