package CabInvoiceGenerator.exceptions;

public class CabInvoiceException extends RuntimeException {
    public ERROR_TYPE errorType;
    public CabInvoiceException(ERROR_TYPE errorType) {
        this.errorType=errorType;
    }

    public enum ERROR_TYPE {
        NEGATIVE_INPUTS {}
    }
}
