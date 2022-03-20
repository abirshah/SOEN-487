
package com.example.client.soapClient;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.client.soapClient package. 
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

    private final static QName _FetchAll_QNAME = new QName("http://logEntry.rest.example.com/", "fetchAll");
    private final static QName _FetchFromDateToDateWithLogType_QNAME = new QName("http://logEntry.rest.example.com/", "fetchFromDateToDateWithLogType");
    private final static QName _FetchFromDateToDate_QNAME = new QName("http://logEntry.rest.example.com/", "fetchFromDateToDate");
    private final static QName _FetchAllWithLogTypeResponse_QNAME = new QName("http://logEntry.rest.example.com/", "fetchAllWithLogTypeResponse");
    private final static QName _FetchFromDate_QNAME = new QName("http://logEntry.rest.example.com/", "fetchFromDate");
    private final static QName _FetchFromDateToDateWithLogTypeResponse_QNAME = new QName("http://logEntry.rest.example.com/", "fetchFromDateToDateWithLogTypeResponse");
    private final static QName _DeleteAllResponse_QNAME = new QName("http://logEntry.rest.example.com/", "deleteAllResponse");
    private final static QName _FetchFromDateToDateResponse_QNAME = new QName("http://logEntry.rest.example.com/", "fetchFromDateToDateResponse");
    private final static QName _DeleteAll_QNAME = new QName("http://logEntry.rest.example.com/", "deleteAll");
    private final static QName _FetchAllWithLogType_QNAME = new QName("http://logEntry.rest.example.com/", "fetchAllWithLogType");
    private final static QName _FetchFromDateResponse_QNAME = new QName("http://logEntry.rest.example.com/", "fetchFromDateResponse");
    private final static QName _FetchAllResponse_QNAME = new QName("http://logEntry.rest.example.com/", "fetchAllResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.client.soapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FetchFromDate }
     * 
     */
    public FetchFromDate createFetchFromDate() {
        return new FetchFromDate();
    }

    /**
     * Create an instance of {@link FetchFromDateToDateWithLogTypeResponse }
     * 
     */
    public FetchFromDateToDateWithLogTypeResponse createFetchFromDateToDateWithLogTypeResponse() {
        return new FetchFromDateToDateWithLogTypeResponse();
    }

    /**
     * Create an instance of {@link FetchAllWithLogTypeResponse }
     * 
     */
    public FetchAllWithLogTypeResponse createFetchAllWithLogTypeResponse() {
        return new FetchAllWithLogTypeResponse();
    }

    /**
     * Create an instance of {@link FetchFromDateToDateWithLogType }
     * 
     */
    public FetchFromDateToDateWithLogType createFetchFromDateToDateWithLogType() {
        return new FetchFromDateToDateWithLogType();
    }

    /**
     * Create an instance of {@link FetchAll }
     * 
     */
    public FetchAll createFetchAll() {
        return new FetchAll();
    }

    /**
     * Create an instance of {@link FetchFromDateToDate }
     * 
     */
    public FetchFromDateToDate createFetchFromDateToDate() {
        return new FetchFromDateToDate();
    }

    /**
     * Create an instance of {@link DeleteAll }
     * 
     */
    public DeleteAll createDeleteAll() {
        return new DeleteAll();
    }

    /**
     * Create an instance of {@link FetchAllResponse }
     * 
     */
    public FetchAllResponse createFetchAllResponse() {
        return new FetchAllResponse();
    }

    /**
     * Create an instance of {@link FetchAllWithLogType }
     * 
     */
    public FetchAllWithLogType createFetchAllWithLogType() {
        return new FetchAllWithLogType();
    }

    /**
     * Create an instance of {@link FetchFromDateResponse }
     * 
     */
    public FetchFromDateResponse createFetchFromDateResponse() {
        return new FetchFromDateResponse();
    }

    /**
     * Create an instance of {@link DeleteAllResponse }
     * 
     */
    public DeleteAllResponse createDeleteAllResponse() {
        return new DeleteAllResponse();
    }

    /**
     * Create an instance of {@link FetchFromDateToDateResponse }
     * 
     */
    public FetchFromDateToDateResponse createFetchFromDateToDateResponse() {
        return new FetchFromDateToDateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchAll")
    public JAXBElement<FetchAll> createFetchAll(FetchAll value) {
        return new JAXBElement<FetchAll>(_FetchAll_QNAME, FetchAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchFromDateToDateWithLogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchFromDateToDateWithLogType")
    public JAXBElement<FetchFromDateToDateWithLogType> createFetchFromDateToDateWithLogType(FetchFromDateToDateWithLogType value) {
        return new JAXBElement<FetchFromDateToDateWithLogType>(_FetchFromDateToDateWithLogType_QNAME, FetchFromDateToDateWithLogType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchFromDateToDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchFromDateToDate")
    public JAXBElement<FetchFromDateToDate> createFetchFromDateToDate(FetchFromDateToDate value) {
        return new JAXBElement<FetchFromDateToDate>(_FetchFromDateToDate_QNAME, FetchFromDateToDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchAllWithLogTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchAllWithLogTypeResponse")
    public JAXBElement<FetchAllWithLogTypeResponse> createFetchAllWithLogTypeResponse(FetchAllWithLogTypeResponse value) {
        return new JAXBElement<FetchAllWithLogTypeResponse>(_FetchAllWithLogTypeResponse_QNAME, FetchAllWithLogTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchFromDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchFromDate")
    public JAXBElement<FetchFromDate> createFetchFromDate(FetchFromDate value) {
        return new JAXBElement<FetchFromDate>(_FetchFromDate_QNAME, FetchFromDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchFromDateToDateWithLogTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchFromDateToDateWithLogTypeResponse")
    public JAXBElement<FetchFromDateToDateWithLogTypeResponse> createFetchFromDateToDateWithLogTypeResponse(FetchFromDateToDateWithLogTypeResponse value) {
        return new JAXBElement<FetchFromDateToDateWithLogTypeResponse>(_FetchFromDateToDateWithLogTypeResponse_QNAME, FetchFromDateToDateWithLogTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "deleteAllResponse")
    public JAXBElement<DeleteAllResponse> createDeleteAllResponse(DeleteAllResponse value) {
        return new JAXBElement<DeleteAllResponse>(_DeleteAllResponse_QNAME, DeleteAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchFromDateToDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchFromDateToDateResponse")
    public JAXBElement<FetchFromDateToDateResponse> createFetchFromDateToDateResponse(FetchFromDateToDateResponse value) {
        return new JAXBElement<FetchFromDateToDateResponse>(_FetchFromDateToDateResponse_QNAME, FetchFromDateToDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "deleteAll")
    public JAXBElement<DeleteAll> createDeleteAll(DeleteAll value) {
        return new JAXBElement<DeleteAll>(_DeleteAll_QNAME, DeleteAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchAllWithLogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchAllWithLogType")
    public JAXBElement<FetchAllWithLogType> createFetchAllWithLogType(FetchAllWithLogType value) {
        return new JAXBElement<FetchAllWithLogType>(_FetchAllWithLogType_QNAME, FetchAllWithLogType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchFromDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchFromDateResponse")
    public JAXBElement<FetchFromDateResponse> createFetchFromDateResponse(FetchFromDateResponse value) {
        return new JAXBElement<FetchFromDateResponse>(_FetchFromDateResponse_QNAME, FetchFromDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logEntry.rest.example.com/", name = "fetchAllResponse")
    public JAXBElement<FetchAllResponse> createFetchAllResponse(FetchAllResponse value) {
        return new JAXBElement<FetchAllResponse>(_FetchAllResponse_QNAME, FetchAllResponse.class, null, value);
    }

}
