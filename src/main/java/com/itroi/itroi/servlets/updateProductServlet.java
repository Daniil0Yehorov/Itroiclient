package com.itroi.itroi.servlets;
import com.itroi.itroi.serviceimpl.Product;
import com.itroi.itroi.serviceimpl.ProductService;
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
import java.lang.Exception;

import java.util.List;


@WebServlet("/update-product")
public class updateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(updateProductServlet.class);
    private transient ProductService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (ProductService) ctx.getAttribute("ProductService");
        if (service == null) {
            log.error("ProductService not initialized");
            throw new ServletException("ProductService is not initialized in the servlet context.");
        }
        log.trace("Initialized UpdateProductServlet with ProductService: {}", service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Received GET request to '/update-product'");

        List<Product> products=null;
        try {
            products = service.getAllProducts();
            log.info("Fetched {} products for admin update view", products.size());
        } catch (Exception e) {
            log.error("Error fetching products", e);
            throw new ServletException("Failed to fetch products", e);
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("/admin/update-product.jsp").forward(req, resp);

        log.debug("Products passed to JSP: {}", products);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Received POST request to '/update-product'");

        String action = req.getParameter("action");

        try {
            if ("update".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String description = req.getParameter("description");
                double price = Double.parseDouble(req.getParameter("price"));
                String category = req.getParameter("category");
                int countInStock = Integer.parseInt(req.getParameter("countInStock"));

                Product product = new Product();
                product.setID(id);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                product.setCategory(category);
                product.setCountInStock(countInStock);

                service.updateProduct(product);
                log.info("Successfully updated product with ID: {}", id);

            } else if ("delete".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                service.deleteProduct(id);
                log.info("Successfully deleted product with ID: {}", id);
            }

            resp.sendRedirect("/update-product");

        } catch (Exception e) {
            log.error("Failed to process product action", e);
            throw new ServletException("Error processing product action", e);
        }
    }
}