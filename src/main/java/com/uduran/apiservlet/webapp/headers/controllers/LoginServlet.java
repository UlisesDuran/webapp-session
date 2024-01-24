package com.uduran.apiservlet.webapp.headers.controllers;

import com.uduran.apiservlet.webapp.headers.services.LoginService;
import com.uduran.apiservlet.webapp.headers.services.LoginServiceCookieImpl;
import com.uduran.apiservlet.webapp.headers.services.LoginServiceHttpSessionImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService loginService = new LoginServiceHttpSessionImpl();
        Optional<String> usernameOptional = loginService.getUsername(req);
        HttpSession session = req.getSession();

        if (usernameOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");

            try(PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("       <meta charset=\"UTF-8\">");
                out.println("       <title>Hola " + (session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo") + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + (session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo") + " has iniciado sesion exito! </h1>");
                out.println("        <p><a href='" + req.getContextPath() + "/logout'>Cerrar sesión</a></p>");
                out.println("        <p><a href='" + req.getContextPath() + "/index.jsp'>Volver</a></p>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }else{
            //Enviamos error.
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta pagina!");
        }
    }
}
