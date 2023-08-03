import util.Adder;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        Function<Integer, Integer> myAdder = new Adder();
//        Integer result = myAdder.apply(10);
//        System.out.println("result = " + result);

//        Function<Integer, Integer> myAdder = (Integer x) ->{
//            return x + 10;
//        };

        //간락하게 만들기
        // 앞에 InputType을 Integer로 선언을 하였기 때문에 매개변수 내 Integer를 새략이 가능하다.
        Function<Integer, Integer> myAdder = x -> x + 10;

        Integer result = myAdder.apply(10);
        System.out.println("result = " + result);
    }
}
