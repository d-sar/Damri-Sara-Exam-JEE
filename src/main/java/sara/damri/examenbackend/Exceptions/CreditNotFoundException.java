package sara.damri.examenbackend.Exceptions;

public class CreditNotFoundException extends RuntimeException {
    public CreditNotFoundException(String message) {
        super(message);
    }
}
