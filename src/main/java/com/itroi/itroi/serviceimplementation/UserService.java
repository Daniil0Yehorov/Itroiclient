
package com.itroi.itroi.serviceimplementation;

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
@WebService(name = "UserService", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/")
@XmlSeeAlso({
    com.itroi.itroi.exception.ObjectFactory.class,
    com.itroi.itroi.serviceimplementation.ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.DeleteUserResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/UserService/deleteUserRequest", output = "http://ServiceImplementation.itroi.itroi.com/UserService/deleteUserResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/UserService/deleteUser/Fault/ClientFaultException")
    })
    public void deleteUser(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.UpdateUserResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/UserService/updateUserRequest", output = "http://ServiceImplementation.itroi.itroi.com/UserService/updateUserResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/UserService/updateUser/Fault/ClientFaultException")
    })
    public void updateUser(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        User arg1)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "createUser", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.CreateUserResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/UserService/createUserRequest", output = "http://ServiceImplementation.itroi.itroi.com/UserService/createUserResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/UserService/createUser/Fault/ClientFaultException")
    })
    public void createUser(
        @WebParam(name = "arg0", targetNamespace = "")
        User arg0)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.User
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserforAuth", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetUserforAuth")
    @ResponseWrapper(localName = "getUserforAuthResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetUserforAuthResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/UserService/getUserforAuthRequest", output = "http://ServiceImplementation.itroi.itroi.com/UserService/getUserforAuthResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/UserService/getUserforAuth/Fault/ClientFaultException")
    })
    public User getUserforAuth(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws ClientFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itroi.itroi.serviceimplementation.User
     * @throws ClientFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://ServiceImplementation.itroi.itroi.com/", className = "com.itroi.itroi.serviceimplementation.GetUserByIdResponse")
    @Action(input = "http://ServiceImplementation.itroi.itroi.com/UserService/getUserByIdRequest", output = "http://ServiceImplementation.itroi.itroi.com/UserService/getUserByIdResponse", fault = {
        @FaultAction(className = ClientFaultException_Exception.class, value = "http://ServiceImplementation.itroi.itroi.com/UserService/getUserById/Fault/ClientFaultException")
    })
    public User getUserById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClientFaultException_Exception
    ;

}
