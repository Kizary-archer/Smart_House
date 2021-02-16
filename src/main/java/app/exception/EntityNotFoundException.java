package app.exception;

public class EntityNotFoundException extends AbstractRuntimeExceptionWithFieldName{

    public EntityNotFoundException(String message, String fieldName) {
        super(message, fieldName);
    }
}
