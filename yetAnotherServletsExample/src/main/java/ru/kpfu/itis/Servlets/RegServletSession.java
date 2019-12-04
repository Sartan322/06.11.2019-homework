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
import java.io.IOException;

@WebServlet(name = "Servlets.RegServletSession", urlPatterns = "/reg")
public class RegServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DbController dbController = new DbController();
        dbController.connect();
        String button = req.getParameter("button");

        String login = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String selfName = req.getParameter("selfName");
        String inform = req.getParameter("information");
        int city = Integer.parseInt(req.getParameter("city"));
        String avatar = req.getParameter("avatar");
        String bDay = req.getParameter("bday");
        User user = new User(login,password,avatar,name,selfName,inform,city,bDay);

        UserRepository userRepository = new UserRepositoryImpl(dbController.getConnection());
        if(button != null){
            userRepository.save(user);
            resp.sendRedirect("/servletExample_war/auth");
        }
/*
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
*/
    }
}
