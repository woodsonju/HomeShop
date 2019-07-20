package homeshop;

public class TakeAwayDelivery implements Delivery{

    public double getPrice() {
        return 0;
    }

    public String getInfo() {
        return "Rétrait 0.00€";
    }
}
