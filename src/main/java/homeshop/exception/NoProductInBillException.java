package homeshop.exception;

public class NoProductInBillException extends RuntimeException{
    public NoProductInBillException(String message) {
        super(message);
    }
}
