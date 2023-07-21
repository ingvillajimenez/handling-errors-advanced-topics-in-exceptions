public class InvalidUsernameException extends RuntimeException {

    public InvalidUsernameException(String errorMessage) {
        super(errorMessage);
        this.initCause(new RuntimeException("The username must begin with loony_"));
    }
}
