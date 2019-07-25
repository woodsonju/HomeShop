package homeshop.dao;

import homeshop.product.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    
   private String url = "jdbc:mysql://localhost/homeshop";
   private String user = "root";
   private String pwd = "";

    /**
     * Get all products on database
     * @return product list
     */
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from product");
            while(rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                products.add(new Product(name, description, price));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connexion impossible");
        }
        return products;
    }
}
