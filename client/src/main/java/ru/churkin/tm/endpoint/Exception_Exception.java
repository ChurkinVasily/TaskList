
package ru.churkin.tm.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2019-03-21T13:42:13.511+03:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "Exception", targetNamespace = "http://endpoint.tm.churkin.ru/")
public class Exception_Exception extends java.lang.Exception {
    
    private ru.churkin.tm.endpoint.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, ru.churkin.tm.endpoint.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, ru.churkin.tm.endpoint.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public ru.churkin.tm.endpoint.Exception getFaultInfo() {
        return this.exception;
    }
}
