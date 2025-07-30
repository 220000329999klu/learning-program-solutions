package p1;
import java.util.Arrays;
import java.util.Comparator;

public class SearchUtility {

    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].name.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String targetName) {
        Arrays.sort(products, Comparator.comparing(p -> p.name.toLowerCase()));
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].name.compareToIgnoreCase(targetName);

            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}