
package com.itroi.itroi.serviceimpl;

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
@WebService(name = "productService", targetNamespace = "http://serviceimpl.itroi.itroi.com/")
@XmlSeeAlso({
    com.itroi.itroi.exception.ObjectFactory.class,
    com.itroi.itroi.serviceimpl.ObjectFactory.class
})
public interface ProductService {


    /**
     * 
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteProduct", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.DeleteProduct")
    @ResponseWrapper(localName = "deleteProductResponse", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.DeleteProductResponse")
    @Action(input = "http://serviceimpl.itroi.itroi.com/productService/deleteProductRequest", output = "http://serviceimpl.itroi.itroi.com/productService/deleteProductResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://serviceimpl.itroi.itroi.com/productService/deleteProduct/Fault/ClientFaultException")
    })
    public void deleteProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimpl.Product
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductById", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.GetProductById")
    @ResponseWrapper(localName = "getProductByIdResponse", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.GetProductByIdResponse")
    @Action(input = "http://serviceimpl.itroi.itroi.com/productService/getProductByIdRequest", output = "http://serviceimpl.itroi.itroi.com/productService/getProductByIdResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://serviceimpl.itroi.itroi.com/productService/getProductById/Fault/ClientFaultException")
    })
    public Product getProductById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.itroi.itroi.serviceimpl.Product>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProducts", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.GetAllProducts")
    @ResponseWrapper(localName = "getAllProductsResponse", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.GetAllProductsResponse")
    @Action(input = "http://serviceimpl.itroi.itroi.com/productService/getAllProductsRequest", output = "http://serviceimpl.itroi.itroi.com/productService/getAllProductsResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://serviceimpl.itroi.itroi.com/productService/getAllProducts/Fault/Exception")
    })
    public List<Product> getAllProducts()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateProduct", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.UpdateProduct")
    @ResponseWrapper(localName = "updateProductResponse", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.UpdateProductResponse")
    @Action(input = "http://serviceimpl.itroi.itroi.com/productService/updateProductRequest", output = "http://serviceimpl.itroi.itroi.com/productService/updateProductResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://serviceimpl.itroi.itroi.com/productService/updateProduct/Fault/ClientFaultException")
    })
    public void updateProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Product arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimpl.Product
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addProduct", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.AddProduct")
    @ResponseWrapper(localName = "addProductResponse", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.AddProductResponse")
    @Action(input = "http://serviceimpl.itroi.itroi.com/productService/addProductRequest", output = "http://serviceimpl.itroi.itroi.com/productService/addProductResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://serviceimpl.itroi.itroi.com/productService/addProduct/Fault/ClientFaultException")
    })
    public Product addProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Product arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generateUniqueProductId", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.GenerateUniqueProductId")
    @ResponseWrapper(localName = "generateUniqueProductIdResponse", targetNamespace = "http://serviceimpl.itroi.itroi.com/", className = "com.itroi.itroi.serviceimpl.GenerateUniqueProductIdResponse")
    @Action(input = "http://serviceimpl.itroi.itroi.com/productService/generateUniqueProductIdRequest", output = "http://serviceimpl.itroi.itroi.com/productService/generateUniqueProductIdResponse")
    public int generateUniqueProductId();

}