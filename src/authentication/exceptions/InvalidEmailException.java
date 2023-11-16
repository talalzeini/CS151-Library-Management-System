package src.authentication.exceptions;

public class InvalidEmailException extends InvalidSignUpException{

    public InvalidEmailException(String message){
        super(message);
    }
    
}
