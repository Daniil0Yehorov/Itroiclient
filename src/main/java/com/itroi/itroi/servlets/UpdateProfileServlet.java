package com.itroi.itroi.servlets;
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

@WebServlet("/updateProfile")
public class UpdateProfileServlet  extends  HttpServlet{
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            log.info("User found in session: {}", user.getID());

            String newName = request.getParameter("name");
            String newEmail = request.getParameter("email");
            String newPhone = request.getParameter("phone");

            log.debug("Received new profile data - Name: {}, Email: {}, Phone: {}", newName, newEmail, newPhone);

            user.setName(newName);
            user.setEmail(newEmail);
            user.setPhone(newPhone);

            try {
                log.info("Updating user data for user ID: {}", user.getID());
                service.updateUser(user.getID(), user);
                session.setAttribute("user", user);
                log.info("User data updated successfully for user ID: {}", user.getID());
                response.sendRedirect("/user/dashboard.jsp");
            } catch (Exception e) {
                log.error("Error occurred while updating user data for user ID: {}", user.getID(), e);
                request.setAttribute("error", "Помилка при оновленні даних.");
                request.getRequestDispatcher("/user/dashboard.jsp").forward(request, response);
            }
        } else {
            log.warn("No user found in session, redirecting to login page.");
            response.sendRedirect("login.jsp");
        }
    }
}
