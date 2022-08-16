package az.abbtech.user.phonebook.exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
