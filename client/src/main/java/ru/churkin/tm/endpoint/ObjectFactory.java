
package ru.churkin.tm.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.churkin.tm.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://endpoint.tm.churkin.ru/", "Exception");
    private final static QName _CreateSession_QNAME = new QName("http://endpoint.tm.churkin.ru/", "createSession");
    private final static QName _CreateSessionResponse_QNAME = new QName("http://endpoint.tm.churkin.ru/", "createSessionResponse");
    private final static QName _DeleteSession_QNAME = new QName("http://endpoint.tm.churkin.ru/", "deleteSession");
    private final static QName _DeleteSessionById_QNAME = new QName("http://endpoint.tm.churkin.ru/", "deleteSessionById");
    private final static QName _DeleteSessionByIdResponse_QNAME = new QName("http://endpoint.tm.churkin.ru/", "deleteSessionByIdResponse");
    private final static QName _DeleteSessionResponse_QNAME = new QName("http://endpoint.tm.churkin.ru/", "deleteSessionResponse");
    private final static QName _GetSessionById_QNAME = new QName("http://endpoint.tm.churkin.ru/", "getSessionById");
    private final static QName _GetSessionByIdResponse_QNAME = new QName("http://endpoint.tm.churkin.ru/", "getSessionByIdResponse");
    private final static QName _Validate_QNAME = new QName("http://endpoint.tm.churkin.ru/", "validate");
    private final static QName _ValidateResponse_QNAME = new QName("http://endpoint.tm.churkin.ru/", "validateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.churkin.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link CreateSession }
     * 
     */
    public CreateSession createCreateSession() {
        return new CreateSession();
    }

    /**
     * Create an instance of {@link CreateSessionResponse }
     * 
     */
    public CreateSessionResponse createCreateSessionResponse() {
        return new CreateSessionResponse();
    }

    /**
     * Create an instance of {@link DeleteSession }
     * 
     */
    public DeleteSession createDeleteSession() {
        return new DeleteSession();
    }

    /**
     * Create an instance of {@link DeleteSessionById }
     * 
     */
    public DeleteSessionById createDeleteSessionById() {
        return new DeleteSessionById();
    }

    /**
     * Create an instance of {@link DeleteSessionByIdResponse }
     * 
     */
    public DeleteSessionByIdResponse createDeleteSessionByIdResponse() {
        return new DeleteSessionByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteSessionResponse }
     * 
     */
    public DeleteSessionResponse createDeleteSessionResponse() {
        return new DeleteSessionResponse();
    }

    /**
     * Create an instance of {@link GetSessionById }
     * 
     */
    public GetSessionById createGetSessionById() {
        return new GetSessionById();
    }

    /**
     * Create an instance of {@link GetSessionByIdResponse }
     * 
     */
    public GetSessionByIdResponse createGetSessionByIdResponse() {
        return new GetSessionByIdResponse();
    }

    /**
     * Create an instance of {@link Validate }
     * 
     */
    public Validate createValidate() {
        return new Validate();
    }

    /**
     * Create an instance of {@link ValidateResponse }
     * 
     */
    public ValidateResponse createValidateResponse() {
        return new ValidateResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "createSession")
    public JAXBElement<CreateSession> createCreateSession(CreateSession value) {
        return new JAXBElement<CreateSession>(_CreateSession_QNAME, CreateSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "createSessionResponse")
    public JAXBElement<CreateSessionResponse> createCreateSessionResponse(CreateSessionResponse value) {
        return new JAXBElement<CreateSessionResponse>(_CreateSessionResponse_QNAME, CreateSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "deleteSession")
    public JAXBElement<DeleteSession> createDeleteSession(DeleteSession value) {
        return new JAXBElement<DeleteSession>(_DeleteSession_QNAME, DeleteSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSessionById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "deleteSessionById")
    public JAXBElement<DeleteSessionById> createDeleteSessionById(DeleteSessionById value) {
        return new JAXBElement<DeleteSessionById>(_DeleteSessionById_QNAME, DeleteSessionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSessionByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "deleteSessionByIdResponse")
    public JAXBElement<DeleteSessionByIdResponse> createDeleteSessionByIdResponse(DeleteSessionByIdResponse value) {
        return new JAXBElement<DeleteSessionByIdResponse>(_DeleteSessionByIdResponse_QNAME, DeleteSessionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "deleteSessionResponse")
    public JAXBElement<DeleteSessionResponse> createDeleteSessionResponse(DeleteSessionResponse value) {
        return new JAXBElement<DeleteSessionResponse>(_DeleteSessionResponse_QNAME, DeleteSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "getSessionById")
    public JAXBElement<GetSessionById> createGetSessionById(GetSessionById value) {
        return new JAXBElement<GetSessionById>(_GetSessionById_QNAME, GetSessionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "getSessionByIdResponse")
    public JAXBElement<GetSessionByIdResponse> createGetSessionByIdResponse(GetSessionByIdResponse value) {
        return new JAXBElement<GetSessionByIdResponse>(_GetSessionByIdResponse_QNAME, GetSessionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Validate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "validate")
    public JAXBElement<Validate> createValidate(Validate value) {
        return new JAXBElement<Validate>(_Validate_QNAME, Validate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.churkin.ru/", name = "validateResponse")
    public JAXBElement<ValidateResponse> createValidateResponse(ValidateResponse value) {
        return new JAXBElement<ValidateResponse>(_ValidateResponse_QNAME, ValidateResponse.class, null, value);
    }

}
