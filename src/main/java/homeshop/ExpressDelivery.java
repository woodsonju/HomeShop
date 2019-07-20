package homeshop;

public class ExpressDelivery implements Delivery{

    private String city;
    
    public ExpressDelivery(String city) {
        this.city = city;
    }

    public double getPrice() {
        if(city.equals("Paris"))
            return 6.99;
        else
            return 9.99;
        
    }

    public String getInfo() {
        return "Livraison à domicile express : " + getPrice();
    }
}
