class Product {

    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}

class ProductSearch {

    public static Product searchProduct(Product products[], String searchName) {

        for (Product product : products) {

            if (product.productName.equalsIgnoreCase(searchName)) {
                return product;
            }
        }

        return null;
    }
}

public class ECommerceSearchPlatform {

    public static void main(String[] args) {

        Product products[] = {
                new Product(101, "Laptop", 55000),
                new Product(102, "Mobile", 25000),
                new Product(103, "Headphones", 3000),
                new Product(104, "SmartWatch", 5000)
        };

        String searchItem = "Mobile";

        Product result = ProductSearch.searchProduct(products, searchItem);

        if (result != null) {
            System.out.println("Product Found");
            System.out.println("ID: " + result.productId);
            System.out.println("Name: " + result.productName);
            System.out.println("Price: Rs." + result.price);
        } else {
            System.out.println("Product Not Found");
        }
    }
}