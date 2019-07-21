package homeshop.delivery;


import homeshop.delivery.Delivery;
import homeshop.delivery.RelayDelivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RelayDeliveryTest {
    @Test
    public void Given_FreeRelay_WhenGettingDeliveryPrice_ThenGetOe() {
        Delivery delivery = new RelayDelivery(5);
        assertEquals(0.0, delivery.getPrice(), 0.01);
    }        
    
    @Test
    public void Given_LowPriceRelay_WhenGettingDeliveryPrice_ThenGet2e99() {
        Delivery delivery = new RelayDelivery(27);
        assertEquals(2.99, delivery.getPrice(), 0.01);
    }

    @Test
    public void Given_HighPriceRelay_WhenGettingDeliveryPrice_ThenGet4e99() {
        Delivery delivery = new RelayDelivery(69);
        assertEquals(4.99, delivery.getPrice(), 0.01);
    }

}
