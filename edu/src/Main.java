import chapter4.ConsumerSection;
import chapter4.SupplierSection;

public class Main {
    public static void main(String[] args) {


        ConsumerSection consumerSection = new ConsumerSection();
        System.out.println("------Consumer--------");
        consumerSection.myStringConsumerMethod();
        consumerSection.myStringConsumerMethod("Hello, I'm sangeun");
        consumerSection.integerProcessMethod();
        consumerSection.integerDifferentProcessMethod();
        consumerSection.doubleProcessMethod();

        //chapter4 - supplier<T>
        SupplierSection supplierSection = new SupplierSection();
        System.out.println("------Supplier--------");
        supplierSection.myStringSupplierMethod();
        supplierSection.myRandomDoubleSupplierMethod();
    }


}
