package src.authentication.exceptions;

public class SpecialCharacterMissing extends PasswordException {
    public SpecialCharacterMissing() {
        super("Password must contain at least one special character.");
    }
}