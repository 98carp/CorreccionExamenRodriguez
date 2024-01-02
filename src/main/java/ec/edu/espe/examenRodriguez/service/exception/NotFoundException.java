package ec.edu.espe.examenRodriguez.service.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(String message,Exception cause){
        super(message,cause);
    }
}
