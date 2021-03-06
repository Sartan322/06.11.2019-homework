package ru.kpfu.itis.Servlets;

import db.models.User;
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
import java.util.Optional;

@WebServlet(name = "Servlets.ProfilePageServlet", urlPatterns = "/profile")
public class ProfilePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DbController dbController = new DbController();
        dbController.connect();
        UserRepository userRepository = new UserRepositoryImpl(dbController.getConnection());
        Optional<User> user = userRepository.find(session.getAttribute("login").toString(),session.getAttribute("password").toString());
        if(user != null){
            req.setAttribute("name", user.get().getName());
            req.setAttribute("surname", user.get().getSelfName());
            req.setAttribute("bday", user.get().getbDay());
            req.setAttribute("information", user.get().getSelfInformation());
            req.setAttribute("city", user.get().getCity());
            req.setAttribute("avatar_url", user.get().getAvatar());
            req.getRequestDispatcher("/profile.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("/servletExample_war/auth");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String button = req.getParameter("button");
        if(button.equals("Delete")){
            DbController dbController = new DbController();
            dbController.connect();
            UserRepository userRepository = new UserRepositoryImpl(dbController.getConnection());
            userRepository.delete(session.getAttribute("login").toString(),session.getAttribute("password").toString());
            session.removeAttribute("login");
            session.removeAttribute("password");
            resp.sendRedirect("/servletExample_war/");
        }
        else if(button.equals("Edit")){
            resp.sendRedirect("/servletExample_war/editprofile");
        }
    }
}
