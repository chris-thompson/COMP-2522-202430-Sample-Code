package exceptions;

/**
 * A very important Exception. A Checked Exception.
 */
class VeryImportantException extends Exception {

    /**
     * Returns a String representation of this VeryImportantException.
     * @return representation as a String
     */
    public String toString() {
        return "A very important exception!";
    }
}

/**
 * A trivial Exception.  A Checked Exception.
 */
class TrivialException extends Exception {

    /**
     * Returns a String representation of this TrivialException.
     * @return representation as a String
     */
    public String toString() {
        return "A trivial exception";
    }
}

/**
 * Demonstrates a lost exception.
 *
 * @author BCIT
 * @version 2024
 */
public class LostMessage {

    /**
     * This function does very little.
     * @throws VeryImportantException all the time
     */
    private void veryImportantFunction() throws VeryImportantException {
        throw new VeryImportantException();
    }

    /**
     * This function also does very little.
     * @throws TrivialException all the time
     */
    void trivialFunction() throws TrivialException {
        throw new TrivialException();
    }

    /**
     * Examine the stacktrace. Where is the VeryImportantException? Oh. No.
     * @param args command line arguments (unused)
     * @throws Exception (which will crash the program)
     */
    public static void main(final String[] args) throws Exception {
        LostMessage lostMessage = new LostMessage();
        try {
            lostMessage.veryImportantFunction();
        } finally {
            lostMessage.trivialFunction();
        }
    }
}
