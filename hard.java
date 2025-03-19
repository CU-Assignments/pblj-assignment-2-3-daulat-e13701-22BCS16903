import java.util.*;
import java.util.stream.Collectors;
class Product {
private String name;
private String category;
private double price;
public Product(String name, String category, double price) {
this.name = name;
this.category = category;
this.price = price;
}
public String getName() { return name; }
public String getCategory() { return category; }
public double getPrice() { return price; }
@Override
public String toString() {
return String.format("%-20s | ₹%.2f", name, price);
}
}
public class ProductProcessor {
public static void main(String[] args) {
List<Product> products = Arrays.asList(
new Product("iPhone 15", "Electronics", 79999.99),
new Product("Samsung TV", "Electronics", 55999.50),
new Product("Dell Laptop", "Electronics", 69999.00),
new Product("Nike Shoes", "Fashion", 7999.99),
new Product("Adidas Jacket", "Fashion", 4999.50),
new Product("Rolex Watch", "Accessories", 250000.00),
new Product("Gucci Sunglasses", "Accessories", 14999.75),
new Product("Wooden Dining Table", "Furniture", 29999.99),
new Product("Office Chair", "Furniture", 9999.00)
);
// Group products by category
Map<String, List<Product>> groupedByCategory = products.stream()
.collect(Collectors.groupingBy(Product::getCategory, TreeMap::new,
Collectors.toList()));
Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
.collect(Collectors.groupingBy(Product::getCategory,
Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
double avgPrice = products.stream()
.mapToDouble(Product::getPrice)
.average()
.orElse(0.0);
System.out.println("\n--- Product Categories ---");
groupedByCategory.forEach((category, productList) -> {
System.out.println("\nCategory: " + category);
productList.forEach(System.out::println);
});
System.out.println("\n--- Most Expensive Product in Each Category ---");
mostExpensiveByCategory.forEach((category, product) ->
System.out.println(category + ": " + product.map(Product::toString).orElse("No
product"))
);
System.out.printf("\nAverage Price of All Products: ₹%.2f\n", avgPrice);
}
}
