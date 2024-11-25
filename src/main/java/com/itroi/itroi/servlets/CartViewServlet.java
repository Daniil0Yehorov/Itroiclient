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
import java.util.ArrayList;
import java.util.List;



@WebServlet("/cart/view")
public class CartViewServlet extends HttpServlet {
    private final transient Logger log = LoggerFactory.getLogger(CartViewServlet.class);
    private static final long serialVersionUID = 1L;
    private transient ProductService service;
    private transient CartService Cservice;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (ProductService) ctx.getAttribute("ProductService");
        Cservice = (CartService) ctx.getAttribute("CartService");
        log.trace("Initialized CartViewServlet with ProductService: {} and CartService: {}", service, Cservice);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        try {
            if (user != null) {
                Cart userCart = Cservice.getCartById(user.getID());

                if (userCart != null && userCart.getProductIDs() != null) {
                    List<Integer> productIds = userCart.getProductIDs().getProductID();

                    List<Product> products = new ArrayList<>();

                    for (int productId : productIds) {
                        log.debug("Fetching product with ID: {}", productId);
                        Product product = service.getProductById(productId);
                        log.debug("Fetched product: {}", product);
                        if (product != null) {
                            products.add(product);
                        }
                    }

                    request.setAttribute("cartItems", products);

                    double totalAmount = userCart.getTotalAmount();
                    String status = userCart.getStatus();
                    request.setAttribute("totalAmount", totalAmount);
                    request.setAttribute("status", status);
                    request.getRequestDispatcher("/cart.jsp").forward(request, response);
                    log.debug("Forwarded request to carts.jsp with {} products", (products != null ? products.size() : 0));

                } else {
                    log.info("User ID: {} - Cart is empty.", user.getID());
                    request.setAttribute("error", "Ваш кошик порожній.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    log.debug("Error attribute: {}", request.getAttribute("error"));
                }
            } else {
                log.warn("Attempt to view cart without logging in.");
                response.sendRedirect("login.jsp");
            }
        } catch (ClientFaultException_Exception e) {
            log.error("Client error while viewing cart: {}", e.getMessage(), e);
            request.setAttribute("error", "Помилка клієнта при перегляді кошика.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            log.debug("Error attribute: {}", request.getAttribute("error"));
        }

    }
}