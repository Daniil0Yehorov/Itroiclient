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
import java.util.ArrayList;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final transient Logger log = LoggerFactory.getLogger(RegisterServlet.class);
    private static final long serialVersionUID = 1L;
    private transient UserService service;
    private transient CartService Cservice;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (UserService)  ctx.getAttribute("UserService");
        Cservice = (CartService) ctx.getAttribute("CartService");  // Потрібен сервіс, через створення
        // пустого кошику при реєстрації
        log.trace("Get attribute UserService : {}", service);
        log.trace("Get attribute CartService : {}", Cservice);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User();
        int id= service.generateUniqueUserId();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setType("User");
        user.setID(id);
        User isRegistered = null;
        try {
           service.createUser(user);
           isRegistered = service.getUserById(user.getID());
        } catch (ClientFaultException_Exception e) {
            throw new RuntimeException(e);
        }

        if (isRegistered!=null) {

            Cart cart = new Cart();
            cart.setUserID(user.getID());
            Cart.ProductIDs productIDs = new Cart.ProductIDs();
            productIDs.setProductID(new ArrayList<>());
            cart.setTotalAmount(0.0);
            cart.setStatus("Не оформлений кошик");
            Cservice.addCart(cart);
            log.info("User {} registered successfully", user.getName());
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Помилка при реєстрації");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}