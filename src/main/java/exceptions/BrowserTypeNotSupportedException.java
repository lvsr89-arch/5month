package exceptions;

public class BrowserTypeNotSupportedException extends RuntimeException {

    public BrowserTypeNotSupportedException(String browseType) {
        super(String.format("Browser %s not supported", browseType));
    }
}
