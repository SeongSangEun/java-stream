import chapter8.FindSection;
import chapter8.MatchSection;
import chapter8.ReduceSection;

public class Main {
    public static void main(String[] args) {

        ReduceSection reduceSection = new ReduceSection();
        reduceSection.applyMethod();
        System.out.println("------------------------");
        reduceSection.reduceMethod();

    }


}
