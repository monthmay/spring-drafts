package xyz.demo.thymeleaf.access;

import xyz.demo.thymeleaf.entity.Product;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public final class ProductBuilder {

    public static List<Product> buildProductList(int quantity) {
        double[] prices = {45.6, 332.25, 54, 134.34, 10.5, 22.3, 639.99, 445.99, 69.29, 79.9, 129.67};
        Random random = new Random();

        return new Vector<>() {
            {
                for(int i = 0; i < quantity; i++) {
                    Product product = new Product();

                    product.setName("product-"+(i + 1));

                    product.setStock(random.nextBoolean());

                    product.setPrice(prices[random.nextInt(prices.length)]);

                    add(product);
                }
            }
        };
    }
}
