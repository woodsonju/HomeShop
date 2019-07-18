package homeshop;

import java.util.Map;

public class Bill {
    
    private Customer customer;
    private Map<Product, Integer> products;

    public Customer getCustomer() {
        return customer;
    }
    

    public Map<Product, Integer> getProducts() {
        return products;
    }
    
}
