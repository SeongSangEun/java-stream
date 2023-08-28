package chapter9;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluation {

    public void runMethod() {

        //이미 앞선 true에서 조건을 만족시켰기 때문에 returnFalse()를 수행하지 않음
        if(true || returnFalse()) {
            System.out.println("true = " + true);
        }

        if(or(returnTrue(), returnFalse())){
            System.out.println("or 수행 = " + true);
        }

        if( lazyOr(() -> returnTrue(), () -> returnFalse())){
            System.out.println("Lazy Or 수행");
        }

        //스트림에서 사용법
        Stream<Integer> numberStream = Stream.of(3, -2, 6, 1, 7, 10)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("Peeking x = " + x)) // 컨슈머를 받아서 잠깐 컨슈머를 수행하고 넘어가는 메소드
                .filter(x -> x%2 ==0);

        System.out.println("Before collect");

        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println("After Collect = " + numberList);

        //실행순서 예상 : peek -> Before -> After
        //실세 실행순서 : Before -> peek -> After
        // 스트림은 종결처리가 되기 전까지는 모든 계산을 미룸


    }

    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }

    public static boolean or(boolean x, boolean y) {
        return  x || y;
    }

    public static boolean returnTrue() {
        System.out.println("Returning True");
        return true;
    }
    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }



}
