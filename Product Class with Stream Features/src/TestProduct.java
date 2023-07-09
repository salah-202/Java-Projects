import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.round;

public class TestProduct {
    public static void main(String[] args) {
        List<Product> products = Product.addDummyData();

        //Exercise 1 — Obtain a list of products belongs to category “Books”
        List<Product> booksCategory = products.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .collect(Collectors.toList());

        System.out.println(booksCategory);

        //Exercise 2 — Obtain a list of products belongs to category “Books” with price > 100
        List<Product> booksPriceCategory = products.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(booksPriceCategory);

        //Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Product> toysCategoryDiscount = products.stream()
                .filter(product -> product.getCategory().equals("Toys"))
                .map(product -> product.withPrice((double) round(product.getPrice()*0.9*100) / 100))
                .collect(Collectors.toList());

        System.out.println(toysCategoryDiscount);

        //Exercise 4 — Get the cheapest products of “Books” category
        Product cheapestBook = products.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .min((product, t1) -> product.getPrice() > t1.getPrice() ? 1:-1).get();

        System.out.println(cheapestBook);

    }
}