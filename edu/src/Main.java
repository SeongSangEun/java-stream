import chapter4.ConsumerSection;
import chapter4.SupplierSection;
import chapter6.FilterSection;
import chapter6.MapSection;
import chapter6.StreamSection;

public class Main {
    public static void main(String[] args) {

        MapSection mapSection = new MapSection();
        mapSection.domainStreamMap();
        mapSection.numberStreamMap();
    }


}
