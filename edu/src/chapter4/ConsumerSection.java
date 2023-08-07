package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerSection {
    public void myStringConsumerMethod() {
        Consumer<String> myStringConsumer = (String str) -> System.out.println(str);
        myStringConsumer.accept("hello");
    }
    public void myStringConsumerMethod(String string) {
        Consumer<String> myStringConsumer = (String str) -> System.out.println(str);
        myStringConsumer.accept(string);
    }
    public void integerProcessMethod() {
        List<Integer> integerInputs = Arrays.asList(4, 2, 3); // 변형을 할 수 없음 (추가를 할 수가 없음) immutable
        Consumer<Integer> myIntegerProcessor = (Integer x) -> System.out.println("Processing integer = " + x);
        process(integerInputs, myIntegerProcessor);
    }
    public void integerDifferentProcessMethod() {
        List<Integer> integerInputs = Arrays.asList(4, 2, 3); // 변형을 할 수 없음 (추가를 할 수가 없음) immutable
        Consumer<Integer> differentIntegerProcessor = (Integer x) -> System.out.println("Processing integer in Different way = " + x);
        processWildCard(integerInputs, differentIntegerProcessor);
    }
    public void doubleProcessMethod() {
        List<Double> doubleInputs = Arrays.asList(4.1, 2.2, 3.3); // 변형을 할 수 없음 (추가를 할 수가 없음) immutable
        Consumer<Double> myDoubleProcessor = (Double x) -> System.out.println("Processing double = " + x);
        processWildCard(doubleInputs, myDoubleProcessor);
    }


    //다양한 인티저를 프로세스 하는 함수
    // 프로세스 자체는 공통 코드이며 Consumer<Integer> processor 를 다양화 하고 상황에 맞춘 프로세서를 사용하면 됨.
    public void process(List<Integer> inputs, Consumer<Integer> processor) {
        for (Integer input : inputs) {
            processor.accept(input);
        }
    }
    public <T> void processWildCard(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }


}
