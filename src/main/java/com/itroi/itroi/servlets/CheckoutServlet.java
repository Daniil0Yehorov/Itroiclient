package com.itroi.itroi.servlets;
import com.itroi.itroi.serviceimpl.CartService;
import com.itroi.itroi.serviceimpl.ProductService;
import com.itroi.itroi.serviceimpl.User;
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



@WebServlet("/checkout")
public class CheckoutServlet  extends  HttpServlet{
    private final transient Logger log = LoggerFactory.getLogger(CheckoutServlet.class);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            try {
                log.info("User ID: {} - Checkout process started.", user.getID());

                Cservice.checkout(user.getID());

                log.info("User ID: {} - Checkout successful.", user.getID());
                response.sendRedirect("/cart/view");
            } catch (Exception e) {
                log.error("User ID: {} - Error during checkout: {}", user.getID(), e.getMessage(), e);
                request.setAttribute("errorMessage", "Помилка при оформленні замовлення. Спробуйте знову.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            log.warn("Attempt to checkout without being logged in.");
            response.sendRedirect("login.jsp");
        }

    }
}
