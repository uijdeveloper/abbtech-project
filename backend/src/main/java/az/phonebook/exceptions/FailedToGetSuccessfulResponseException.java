package az.phonebook.exceptions;

public class FailedToGetSuccessfulResponseException extends RuntimeException {

    public FailedToGetSuccessfulResponseException(String msg) {
        super(msg);
    }
}
