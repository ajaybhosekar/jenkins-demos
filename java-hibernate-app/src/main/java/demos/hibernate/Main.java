package demos.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import demos.hibernate.dao.ProductDAO;
import demos.hibernate.entity.Product;

public class Main {
	
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
	                        productDAO.saveProduct(productToAdd);
	                        break;

	                    case 2:
	                        List<Product> products = productDAO.getAllProducts();
	                        products.forEach(System.out::print);
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

}
