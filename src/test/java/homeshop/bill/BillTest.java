package homeshop.bill;

import homeshop.Customer;
import homeshop.exception.NoProductInBillException;
import homeshop.delivery.Delivery;
import homeshop.delivery.RelayDelivery;
import homeshop.product.Fridge;
import homeshop.product.Product;
import homeshop.product.Television;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {
    
    private String output = "";
    
    private Writer writerMock = new Writer() {
        public void start() {
            output="";
        }
        public void writeLine(String line) {
            output += line + "%n";
        }
        public void stop() {

        }
    };

    private Product cafe = new Product("Philips HD7866/61", "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses", 79.99);
    private Product tv = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"", 599, 49, "LED");
    private Fridge fridge = new Fridge("BEKO TSE 1042 F", "Réfrigérateur BEKO 130L - Classe A+ - blanc", 189, 130, false);
    private Customer customer = new Customer("Juste Leblanc", "19 rue Germain Pilon, Paris");
    private Delivery lowCostRelayDelivery = new RelayDelivery(27);
   
    @Test
    public void Given_2productsAndDelivery_When_generatinBill_Then_getGoodLineNumber() {
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        bill.addProduct(cafe, 1);
        bill.addProduct(tv, 1);
        bill.generate(writerMock);
        int linerNumber = output.split("%n").length;
        assertEquals(20, linerNumber);
    }

    @Test
    public void Given_3productsAndDelivery_When_generatinBill_Then_getGoodTotal() {
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        bill.addProduct(cafe, 1);
        bill.addProduct(tv, 1);
        bill.addProduct(fridge, 1);
        assertEquals(870.99, bill.getTotal(), 0.01);
    }
    
    @Test
    public void Given_emptyProductList_generatingBill_then_throwsException() {
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        assertThrows(NoProductInBillException.class, () -> bill.generate(writerMock));
    }
}