package src.authentication.exceptions;

public class NumberCharacterMissing extends PasswordException {
    public NumberCharacterMissing() {
        super("Password must contain at least one digit (number).");
    }
}