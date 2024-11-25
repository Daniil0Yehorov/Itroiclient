package com.itroi.itroi.servlets;

import com.itroi.itroi.serviceimpl.ClientFaultException_Exception;
import com.itroi.itroi.serviceimpl.User;
import com.itroi.itroi.serviceimpl.UserService;
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

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
    private final transient Logger log = LoggerFactory.getLogger(Loginservlet.class);
    private static final long serialVersionUID = 1L;
    private transient UserService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (UserService) ctx.getAttribute("UserService");
        log.trace("Initialized LoginServlet with UserService: {}", service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("Processing POST request to /login");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        log.debug("Received login attempt with login: {}", login);

        User user = null;
        try {
            user = service.getUserforAuth(password, login);
            log.info("Authentication attempt for login '{}' was {}", login, (user != null ? "successful" : "unsuccessful"));
        } catch (ClientFaultException_Exception e) {
            log.error("Error during authentication for login '{}'", login, e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Authentication service error");
            return;
        }

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            log.info("User '{}' logged in successfully as {}", login, user.getType());

            if ("Admin".equals(user.getType())) {
                log.trace("Redirecting admin '{}' to dashboard", login);
                response.sendRedirect("admin/dashboard.jsp"); // admin dashboard
            } else {
                log.trace("Redirecting user '{}' to dashboard", login);
                response.sendRedirect("user/dashboard.jsp"); // user dashboard
            }
        } else {
            log.warn("Failed login attempt for '{}'", login);
            request.setAttribute("error", "Невірний логін або пароль");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}