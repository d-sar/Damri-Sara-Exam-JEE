package sara.damri.examenbackend.Exceptions;

public class ClientNotFoundException extends RuntimeException
{
    public ClientNotFoundException(String message) {
        super(message);
    }
}
