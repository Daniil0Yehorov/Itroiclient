package com.itroi.itroi.servlets;

import com.itroi.itroi.serviceimpl.CartService;
import com.itroi.itroi.serviceimpl.ClientFaultException_Exception;
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

@WebServlet("/cart/add")
public class addToCartServlet extends HttpServlet{
    private final transient Logger log = LoggerFactory.getLogger(addToCartServlet.class);
    private static final long serialVersionUID = 1L;
    private transient ProductService service;
    private transient CartService Cservice;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (ProductService) ctx.getAttribute("ProductService");
        Cservice = (CartService) ctx.getAttribute("CartService");
        log.trace("Initialized AddToCartServlet with ProductService: {} and CartService: {}", service, Cservice);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("Processing POST request to /cart/add");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int productId;

        try {
            productId = Integer.parseInt(request.getParameter("productId"));
            log.debug("Parsed productId: {}", productId);
        } catch (NumberFormatException e) {
            log.error("Failed to parse productId: {}", request.getParameter("productId"), e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
            return;
        }

        if (user != null) {
            try {
                log.info("Adding product {} to cart for user {}", productId, user.getID());
                Cservice.addProductToCart(user.getID(), productId);
                log.info("Product {} successfully added to cart for user {}", productId, user.getID());
                response.sendRedirect("/cart/view");
            } catch (ClientFaultException_Exception e) {
                log.error("Error while adding product {} to cart for user {}", productId, user.getID(), e);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add product to cart");
            }
        } else {
            log.warn("Unauthorized access attempt to /cart/add. Redirecting to login.");
            response.sendRedirect("login.jsp");
        }
    }

}
