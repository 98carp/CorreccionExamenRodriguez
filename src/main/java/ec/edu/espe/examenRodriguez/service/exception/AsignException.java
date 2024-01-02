package ec.edu.espe.examenRodriguez.service.exception;

public class AsignException extends RuntimeException{
    public AsignException(String message){
        super(message);
    }
    public AsignException(String message,Exception cause){
        super(message,cause);
    }
}
