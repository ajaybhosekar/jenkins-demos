package demos.jdbc;
import demos.jdbc.entity.Product;
import demos.jdbc.dao.ProductDAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class JdbcAppMain {
    private static ProductDAO productDAO = null;

    static {
        productDAO = new ProductDAO();
    }
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean flag = true;
            while (flag) {
                System.out.println("Choose from the below options:");
                System.out.println("1: Add new product");
                System.out.println("2: View available products");
                System.out.println("3: Exit");
                int choice = Integer.parseInt(br.readLine());
                switch(choice) {
                    case 1: 
                        Product productToAdd = acceptProductDetails(br);
                        productDAO.createProduct(productToAdd);
                        break;

                    case 2:
                        displayAllProducts();
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        br.close();
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter your choice again.");

                    
                    
                }
                
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        

        
        

        // Update the product
        //product.setName("Gaming Laptop");
        //productDAO.updateProduct(product);

        // Delete the product
        //productDAO.deleteProduct(product.getId());

        
    }

    private static Product acceptProductDetails(BufferedReader br) throws IOException {

        System.out.println("Enter product name: ");
        String name = br.readLine();

        System.out.println("Enter product price: ");
        double price = Double.parseDouble(br.readLine());

        System.out.println("Enter product quantity: ");
        int quantity = Integer.parseInt(br.readLine());

        return new Product(0, name, price, quantity);
    }

    // Read all products
    public static void displayAllProducts() {
        System.out.println("All Products:");
        for (Product p : productDAO.getAllProducts()) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }

    }
}
