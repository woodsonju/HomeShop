package homeshop;

public class DirectDelivery implements Delivery{
    
    public double getPrice() {
        return 4.99;
    }

    public String getInfo() {
        return "Livraison à domicile 4.99€";
    }
}
