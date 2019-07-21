package homeshop.web;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BillServletTest {
    
    @Test
    public void Given_twoParams_when_splitParams_then_fillMapCorrectly() {
        BillServlet billServlet = new BillServlet();
        Map<String, String> params = billServlet.splitParamters("p1=v1&p2=v2");
        assertEquals(2, params.size());
        assertEquals("v1", params.get("p1"));
        assertEquals("v2", params.get("p2"));
    }

    @Test
    public void Given_OneEmptyParamsAndOneGoodParams_When_splitParans_Then_fillMapCorrectly() {
        BillServlet billServlet = new BillServlet();
        Map<String, String> params = billServlet.splitParamters("p1=&p2=v2");
        assertEquals(1, params.size());
        assertEquals("v2", params.get("p2"));
    }

    @Test
    public void Given_NoParams_When_splitParans_Then_fillMapCorrectly() {
        BillServlet billServlet = new BillServlet();
        Map<String, String> params = billServlet.splitParamters("test");
        assertEquals(0, params.size());
    }
}
