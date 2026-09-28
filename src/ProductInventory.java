
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory {

    private List<Product> products;

    public ProductInventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null."
            );
        }

        products.add(product);
    }

    public void removeProduct(String id) {
        products.removeIf(product ->
                product.getId().equals(id)
        );
    }

    public Product findByName(String name) {

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    public double calculateTotalValue() {

        double total = 0;

        for (Product product : products) {
            total += product.calculateFinalPrice();
        }

        return total;
    }
}