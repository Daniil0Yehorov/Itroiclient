
package com.itroi.itroi.exception;

import javax.xml.namespace.QName;
import com.itroi.itroi.serviceimplementation.ClientFaultException;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.itroi.itroi.exception package. 
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

    private final static QName _ClientFault_QNAME = new QName("http://itroi.com/itroi/Exception", "ClientFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.itroi.itroi.exception
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientFaultException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientFaultException }{@code >}
     */
    @XmlElementDecl(namespace = "http://itroi.com/itroi/Exception", name = "ClientFault")
    public JAXBElement<ClientFaultException> createClientFault(ClientFaultException value) {
        return new JAXBElement<ClientFaultException>(_ClientFault_QNAME, ClientFaultException.class, null, value);
    }

}
