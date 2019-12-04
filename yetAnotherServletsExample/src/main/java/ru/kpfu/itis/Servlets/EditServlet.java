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
import java.util.Optional;
@WebServlet(name = "Servlets.EditServlet", urlPatterns = "/editprofile")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DbController dbController = new DbController();
        dbController.connect();
        UserRepository userRepository = new UserRepositoryImpl(dbController.getConnection());
        Optional<db.models.User> user = userRepository.find(session.getAttribute("login").toString(),session.getAttribute("password").toString());
        if(user != null){
            req.setAttribute("name", user.get().getName());
            req.setAttribute("surname", user.get().getSelfName());
            req.setAttribute("information", user.get().getSelfInformation());
            req.getRequestDispatcher("/editprofile.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("/servletExample_war/auth");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String button = req.getParameter("button");
        String newName = req.getParameter("newname");
        String newSurName = req.getParameter("newsurname");
        String newInfo = req.getParameter("newinform");
        if(button.equals("Save")){
            DbController dbController = new DbController();
            dbController.connect();
            UserRepository userRepository = new UserRepositoryImpl(dbController.getConnection());
            userRepository.update(session.getAttribute("login").toString(),session.getAttribute("password").toString(),newName, newSurName, newInfo);
            req.getRequestDispatcher("/editprofile.jsp").forward(req,resp);
            resp.sendRedirect("/servletExample_war/profile");
        }
    }
}
