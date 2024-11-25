package com.itroi.itroi.servlets;
import com.itroi.itroi.serviceimpl.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ProductsServlet  extends HttpServlet  {
    private final transient Logger log = LoggerFactory.getLogger(RegisterServlet.class);
    private static final long serialVersionUID = 1L;
    private transient ProductService service;

    @Override
    public void init()throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (ProductService)  ctx.getAttribute("ProductService");
        log.trace("Get attribute ProductService : {}", service);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Received request to get all products");

        List<Product> products = null;
        try {
            products = service.getAllProducts();
            log.info("Successfully fetched {} products", products.size());
        } catch (Exception_Exception e) {
            log.error("Error fetching products", e);
            throw new ServletException("Failed to fetch products", e);
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);

        log.debug("Forwarded request to products.jsp with {} products", (products != null ? products.size() : 0));
    }
}
