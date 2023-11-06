package src.authentication.exceptions;

public class LowerCaseCharacterMissing extends PasswordException {
    public LowerCaseCharacterMissing() {
        super("Password must contain at least one lowercase character.");
    }
}