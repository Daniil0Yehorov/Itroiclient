
package com.itroi.itroi.serviceimpl;

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
@WebServiceClient(name = "userImplementationService", targetNamespace = "http://serviceimpl.itroi.itroi.com/", wsdlLocation = "http://localhost:8081/ws/users?wsdl")
public class UserImplementationService
    extends Service
{

    private final static URL USERIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException USERIMPLEMENTATIONSERVICE_EXCEPTION;
    private final static QName USERIMPLEMENTATIONSERVICE_QNAME = new QName("http://serviceimpl.itroi.itroi.com/", "userImplementationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/ws/users?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERIMPLEMENTATIONSERVICE_WSDL_LOCATION = url;
        USERIMPLEMENTATIONSERVICE_EXCEPTION = e;
    }

    public UserImplementationService() {
        super(__getWsdlLocation(), USERIMPLEMENTATIONSERVICE_QNAME);
    }

    public UserImplementationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public UserImplementationService(URL wsdlLocation) {
        super(wsdlLocation, USERIMPLEMENTATIONSERVICE_QNAME);
    }

    public UserImplementationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public UserImplementationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserImplementationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UserService
     */
    @WebEndpoint(name = "userImplementationPort")
    public UserService getUserImplementationPort() {
        return super.getPort(new QName("http://serviceimpl.itroi.itroi.com/", "userImplementationPort"), UserService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserService
     */
    @WebEndpoint(name = "userImplementationPort")
    public UserService getUserImplementationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviceimpl.itroi.itroi.com/", "userImplementationPort"), UserService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERIMPLEMENTATIONSERVICE_EXCEPTION!= null) {
            throw USERIMPLEMENTATIONSERVICE_EXCEPTION;
        }
        return USERIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    }

}
