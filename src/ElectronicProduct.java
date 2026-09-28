
import java.io.*;
import java.util.*;

public class ElectronicProduct extends Product implements Discountable {

    private int warrantyMonths;

    public ElectronicProduct(
            String id,
            String name,
            double price,
            int warrantyMonths) {

        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() * 1.10;
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException(
                    "Discount percent must be between 0 and 100."
            );
        }

        double discountedPrice =
                getPrice() * (1 - percent / 100);

        setPrice(discountedPrice);
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }
}