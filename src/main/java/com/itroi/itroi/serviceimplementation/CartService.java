
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
@WebService(name = "CartService", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/")
@XmlSeeAlso({
    com.itroi.itroi.serviceimplementation.ObjectFactory.class,
    com.itroi.itroi.exception.ObjectFactory.class
})
public interface CartService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.Cart
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCartById", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetCartById")
    @ResponseWrapper(localName = "getCartByIdResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetCartByIdResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/getCartByIdRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/getCartByIdResponse")
    public Cart getCartById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "addProductToCart", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.AddProductToCart")
    @ResponseWrapper(localName = "addProductToCartResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.AddProductToCartResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/addProductToCartRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/addProductToCartResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/CartService/addProductToCart/Fault/ClientFaultException")
    })
    public void addProductToCart(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.itroi.itroi.serviceimplementation.Cart>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllCarts", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetAllCarts")
    @ResponseWrapper(localName = "getAllCartsResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetAllCartsResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/getAllCartsRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/getAllCartsResponse")
    public List<Cart> getAllCarts();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.Cart
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCart", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetCart")
    @ResponseWrapper(localName = "getCartResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetCartResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/getCartRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/getCartResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/CartService/getCart/Fault/ClientFaultException")
    })
    public Cart getCart(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addCart", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.AddCart")
    @ResponseWrapper(localName = "addCartResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.AddCartResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/addCartRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/addCartResponse")
    public void addCart(
        @WebParam(name = "arg0", targetNamespace = "")
        Cart arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.Cart
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkout", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.Checkout")
    @ResponseWrapper(localName = "checkoutResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.CheckoutResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/checkoutRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/checkoutResponse")
    public Cart checkout(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "removeProductFromCart", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.RemoveProductFromCart")
    @ResponseWrapper(localName = "removeProductFromCartResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.RemoveProductFromCartResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/CartService/removeProductFromCartRequest", output = "http://ServiceImplementation.itroi.itroi.com/CartService/removeProductFromCartResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/CartService/removeProductFromCart/Fault/ClientFaultException")
    })
    public void removeProductFromCart(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClientFaultException_Exception
    ;

}
