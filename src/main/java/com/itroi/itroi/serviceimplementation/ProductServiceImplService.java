
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
@WebServiceClient(name = "ProductServiceImplService", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", wsdlLocation = "http://localhost:8081/ws/products?wsdl")
public class ProductServiceImplService
    extends Service
{

    private final static URL PRODUCTSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException PRODUCTSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName PRODUCTSERVICEIMPLSERVICE_QNAME = new QName("http://ServiceImplementation.itroi.itroi.com/", "ProductServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/ws/products?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRODUCTSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        PRODUCTSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public ProductServiceImplService() {
        super(__getWsdlLocation(), PRODUCTSERVICEIMPLSERVICE_QNAME);
    }

    public ProductServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCTSERVICEIMPLSERVICE_QNAME, features);
    }

    public ProductServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, PRODUCTSERVICEIMPLSERVICE_QNAME);
    }

    public ProductServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCTSERVICEIMPLSERVICE_QNAME, features);
    }

    public ProductServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProductService
     */
    @WebEndpoint(name = "ProductServiceImplPort")
    public ProductService getProductServiceImplPort() {
        return super.getPort(new QName("http://ServiceImplementation.itroi.itroi.com/", "ProductServiceImplPort"), ProductService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductService
     */
    @WebEndpoint(name = "ProductServiceImplPort")
    public ProductService getProductServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ServiceImplementation.itroi.itroi.com/", "ProductServiceImplPort"), ProductService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCTSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw PRODUCTSERVICEIMPLSERVICE_EXCEPTION;
        }
        return PRODUCTSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
