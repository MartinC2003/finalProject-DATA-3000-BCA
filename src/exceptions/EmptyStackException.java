package exceptions;
/**
 * Thrown when an operation is attempted on an empty stack/queue.
 */
public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super("The structure is empty.");
    }

    public EmptyStackException(String message) {
        super(message);
    }
}
