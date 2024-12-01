package com.itroi.itroi.servlets;
import com.itroi.itroi.serviceimpl.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.Exception;

@WebServlet("/add-product")
public class addProductServlet extends HttpServlet {
    private final transient Logger log = LoggerFactory.getLogger(addProductServlet.class);
    private static final long serialVersionUID = 1L;
    private transient ProductService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (ProductService) ctx.getAttribute("ProductService");
        if (service == null) {
            log.error("Failed to initialize ProductService. Context returned null.");
            throw new ServletException("ProductService is not initialized in the servlet context.");
        }
        log.trace("Initialized AddProductServlet with ProductService: {}", service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Received GET request to '/add-product' from session: {}", req.getSession().getId());
        try {
            req.getRequestDispatcher("/admin/add-product.jsp").forward(req, resp);
            log.info("Forwarded to 'add-product.jsp' for session: {}", req.getSession().getId());
        } catch (Exception e) {
            log.error("Failed to forward to 'add-product.jsp'", e);
            throw new ServletException("Error forwarding to add-product.jsp", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Received POST request to '/add-product' from session: {}", req.getSession().getId());

        try {

            String name = req.getParameter("name");
            String description = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));
            String category = req.getParameter("category");
            int countInStock = Integer.parseInt(req.getParameter("countInStock"));

            log.debug("Parsed product data: name={}, description={}, price={}, category={}, countInStock={}",
                    name, description, price, category, countInStock);

            int id = service.generateUniqueProductId();
            Product newProduct = new Product();
            newProduct.setID(id);
            newProduct.setName(name);
            newProduct.setDescription(description);
            newProduct.setPrice(price);
            newProduct.setCategory(category);
            newProduct.setCountInStock(countInStock);

            log.info("Generated product with ID: {}", id);

            service.addProduct(newProduct);
            log.info("Successfully added product with ID: {} by user: {}", id, req.getSession().getAttribute("user"));

            resp.sendRedirect("admin/dashboard.jsp");
            log.info("Redirected admin '{}' to dashboard", req.getSession().getAttribute("user"));
        } catch (NumberFormatException e) {
            log.error("Invalid number format in request parameters", e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format.");
        } catch (Exception e) {
            log.error("Failed to add product", e);
            throw new ServletException("Error adding product", e);
        }
    }
}