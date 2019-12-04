package ru.kpfu.itis.Servlets;

import ru.kpfu.itis.db.DbController;
import ru.kpfu.itis.db.repositories.UserRepository;
import ru.kpfu.itis.db.repositories.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlets.AuthServlet", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("login") != null && session.getAttribute("password") != null) {

        } else {
            DbController dbController = new DbController();
            dbController.connect();
            String button = req.getParameter("button");

            String login = req.getParameter("email");
            String password = req.getParameter("password");

            if (button.equals("Login")) {
                UserRepository userRepository = new UserRepositoryImpl(dbController.getConnection());
                if (userRepository.checkValidation(login, password)) {
                    session.setAttribute("login", login);
                    session.setAttribute("password", password);
                    resp.sendRedirect("profile");
                } else {
                    req.setAttribute("error", "Oshibochka vishla");
                    req.getRequestDispatcher("/auth.jsp").forward(req, resp);
                }
            } else if (button.equals("Registration")) {
                resp.sendRedirect("/servletExample_war/reg");
            }
        }
    }
}
