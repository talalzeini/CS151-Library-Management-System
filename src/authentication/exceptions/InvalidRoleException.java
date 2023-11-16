package src.authentication.exceptions;

public class InvalidRoleException extends InvalidSignUpException{
    public InvalidRoleException(){
        super("The selected role is invalid, please try again by entering the appropriate role from above.");
    }
}
