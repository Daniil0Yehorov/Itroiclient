
package com.itroi.itroi.serviceimplementation;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ProductService", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/")
@XmlSeeAlso({
    com.itroi.itroi.exception.ObjectFactory.class,
    com.itroi.itroi.serviceimplementation.ObjectFactory.class
})
public interface ProductService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.Product
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductById", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetProductById")
    @ResponseWrapper(localName = "getProductByIdResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetProductByIdResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/ProductService/getProductByIdRequest", output = "http://ServiceImplementation.itroi.itroi.com/ProductService/getProductByIdResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/ProductService/getProductById/Fault/ClientFaultException")
    })
    public Product getProductById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteProduct", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.DeleteProduct")
    @ResponseWrapper(localName = "deleteProductResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.DeleteProductResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/ProductService/deleteProductRequest", output = "http://ServiceImplementation.itroi.itroi.com/ProductService/deleteProductResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/ProductService/deleteProduct/Fault/ClientFaultException")
    })
    public void deleteProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateProduct", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.UpdateProduct")
    @ResponseWrapper(localName = "updateProductResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.UpdateProductResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/ProductService/updateProductRequest", output = "http://ServiceImplementation.itroi.itroi.com/ProductService/updateProductResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/ProductService/updateProduct/Fault/ClientFaultException")
    })
    public void updateProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Product arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.itroi.itroi.serviceimplementation.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProducts", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetAllProducts")
    @ResponseWrapper(localName = "getAllProductsResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetAllProductsResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/ProductService/getAllProductsRequest", output = "http://ServiceImplementation.itroi.itroi.com/ProductService/getAllProductsResponse")
    public List<Product> getAllProducts();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.Product
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addProduct", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.AddProduct")
    @ResponseWrapper(localName = "addProductResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.AddProductResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/ProductService/addProductRequest", output = "http://ServiceImplementation.itroi.itroi.com/ProductService/addProductResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/ProductService/addProduct/Fault/ClientFaultException")
    })
    public Product addProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Product arg0)
        throws ClientFaultException_Exception
    ;

}
