
package com.itroi.itroi.serviceimplementation;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CartServiceImplService", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", wsdlLocation = "http://localhost:8081/ws/carts?wsdl")
public class CartServiceImplService
    extends Service
{

    private final static URL CARTSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CARTSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName CARTSERVICEIMPLSERVICE_QNAME = new QName("http://ServiceImplementation.itroi.itroi.com/", "CartServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/ws/carts?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CARTSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        CARTSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public CartServiceImplService() {
        super(__getWsdlLocation(), CARTSERVICEIMPLSERVICE_QNAME);
    }

    public CartServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CARTSERVICEIMPLSERVICE_QNAME, features);
    }

    public CartServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, CARTSERVICEIMPLSERVICE_QNAME);
    }

    public CartServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CARTSERVICEIMPLSERVICE_QNAME, features);
    }

    public CartServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CartServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CartService
     */
    @WebEndpoint(name = "CartServiceImplPort")
    public CartService getCartServiceImplPort() {
        return super.getPort(new QName("http://ServiceImplementation.itroi.itroi.com/", "CartServiceImplPort"), CartService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CartService
     */
    @WebEndpoint(name = "CartServiceImplPort")
    public CartService getCartServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ServiceImplementation.itroi.itroi.com/", "CartServiceImplPort"), CartService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CARTSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw CARTSERVICEIMPLSERVICE_EXCEPTION;
        }
        return CARTSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}