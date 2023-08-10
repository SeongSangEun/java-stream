import chapter4.ConsumerSection;
import chapter4.SupplierSection;
import chapter6.FilterSection;
import chapter6.StreamSection;

public class Main {
    public static void main(String[] args) {

        FilterSection filterSection = new FilterSection();
        filterSection.orderFilter();
        filterSection.userFilter();

        filterSection.positiveNumberFilter();

        System.out.println("------------------------------");
        StreamSection streamSection = new StreamSection();
        streamSection.StreamToCollection();

    }


}
