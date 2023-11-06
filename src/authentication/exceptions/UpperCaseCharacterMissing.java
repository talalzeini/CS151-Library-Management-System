package src.authentication.exceptions;

public class UpperCaseCharacterMissing extends PasswordException {
    public UpperCaseCharacterMissing() {
        super("Password must contain at least one uppercase character.");
    }
}