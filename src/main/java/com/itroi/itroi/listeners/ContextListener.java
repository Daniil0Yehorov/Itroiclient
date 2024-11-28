package com.itroi.itroi.listeners;

import com.itroi.itroi.ServiceProvider;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext ctx = event.getServletContext();
        log.trace("Context initialized");

        //  отримання з контексту wsdl
        String userWsdlUrl = ctx.getInitParameter("userWsdl");
        String productWsdlUrl = ctx.getInitParameter("productWsdl");
        String cartWsdlUrl = ctx.getInitParameter("cartWsdl");

        // логування юрл для перевірки
        log.debug("User WSDL URL: {}", userWsdlUrl);
        log.debug("Product WSDL URL: {}", productWsdlUrl);
        log.debug("Cart WSDL URL: {}", cartWsdlUrl);

        if (userWsdlUrl != null && !userWsdlUrl.isEmpty()) {
            ctx.setAttribute("UserService", ServiceProvider.getUserServiceInstance(userWsdlUrl));
        } else {
            log.error("UserService WSDL URL is invalid: {}", userWsdlUrl);
        }

        if (productWsdlUrl != null && !productWsdlUrl.isEmpty()) {
            ctx.setAttribute("ProductService", ServiceProvider.getProductServiceInstance(productWsdlUrl));
        } else {
            log.error("ProductService WSDL URL is invalid: {}", productWsdlUrl);
        }

        if (cartWsdlUrl != null && !cartWsdlUrl.isEmpty()) {
            ctx.setAttribute("CartService", ServiceProvider.getCartServiceInstance(cartWsdlUrl));
        } else {
            log.error("CartService WSDL URL is invalid: {}", cartWsdlUrl);
        }

        log.info("Services initialized and added to servlet context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info("Servlet context destroyed");
    }
}