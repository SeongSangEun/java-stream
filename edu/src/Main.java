import chapter8.*;

public class Main {
    public static void main(String[] args) {

        ParallelSection parallelSection =new ParallelSection();
        parallelSection.sendEmailForEach();
        parallelSection.sendEmailParallel();
    }

}
