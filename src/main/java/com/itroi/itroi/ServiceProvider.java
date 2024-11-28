package com.itroi.itroi;
import com.itroi.itroi.serviceimpl.CartService;
import com.itroi.itroi.serviceimpl.ProductService;
import com.itroi.itroi.serviceimpl.UserImplementationService;
import com.itroi.itroi.serviceimpl.UserService;

import java.net.MalformedURLException;
import java.net.URL;


public class ServiceProvider {
    private static UserService users;
    private static ProductService products;
    private static CartService carts;

    private static String userWsdlUrl;
    private static String productWsdlUrl;
    private static String cartWsdlUrl;

    private ServiceProvider() {}
    //UserService

    private static UserService getDefaultUsers() {
        com.itroi.itroi.serviceimpl.UserImplementationService port =
                new com.itroi.itroi.serviceimpl.UserImplementationService();
       // port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
        return port.getUserImplementationPort();
    }
    private static UserService getUsers(String url) throws MalformedURLException {
        UserImplementationService port =
                new com.itroi.itroi.serviceimpl.UserImplementationService(new URL(url));
       // port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
        return port.getUserImplementationPort();
    }
    //CartService
    private static CartService getDefaultCarts() {
        com.itroi.itroi.serviceimpl.CartImplementationService port =
                new com.itroi.itroi.serviceimpl.CartImplementationService();
        // port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
        return port.getCartImplementationPort();
    }
    private static CartService getCarts(String url) throws MalformedURLException {
        com.itroi.itroi.serviceimpl.CartImplementationService port =
                new com.itroi.itroi.serviceimpl.CartImplementationService(new URL(url));
        // port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
        return port.getCartImplementationPort();
    }
    //Products
    private static ProductService getDefaultProducts() {
        com.itroi.itroi.serviceimpl.ProductImplementationService port =
                new com.itroi.itroi.serviceimpl.ProductImplementationService();
        // port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
        return port.getProductImplementationPort();
    }
    private static ProductService getProducts(String url) throws MalformedURLException {
        com.itroi.itroi.serviceimpl.ProductImplementationService port =
                new com.itroi.itroi.serviceimpl.ProductImplementationService(new URL(url));
        // port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
        return port.getProductImplementationPort();
    }


    public static synchronized UserService getUserServiceInstance(String url) {
        if (users == null || (url != null && !url.equals(userWsdlUrl))) {
            try {
                users = getUsers(url);
                userWsdlUrl = url;
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid UserService WSDL URL: " + url, e);
            }
        }
        return users;
    }

    public static synchronized ProductService getProductServiceInstance(String url) {
        if (products == null || (url != null && !url.equals(productWsdlUrl))) {
            try {
                products = getProducts(url);
                productWsdlUrl = url;
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid ProductService WSDL URL: " + url, e);
            }
        }
        return products;
    }

    public static synchronized CartService getCartServiceInstance(String url) {
        if (carts== null || (url != null && !url.equals(cartWsdlUrl))) {
            try {
                carts = getCarts(url);
                cartWsdlUrl = url;
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid CartService WSDL URL: " + url, e);
            }
        }
        return carts;
    }
}