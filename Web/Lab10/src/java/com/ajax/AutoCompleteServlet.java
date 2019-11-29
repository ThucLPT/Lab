package com.ajax;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AutoCompleteServlet extends HttpServlet {

    private ComposerData compData = new ComposerData();
    private HashMap composers = compData.getComposers();
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AutoCompleteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AutoCompleteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuffer sb = new StringBuffer();
        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        boolean namesAdded = false;
        if (action.equals("complete")) {
            if (!targetId.equals("")) {
                Iterator it = composers.keySet().iterator();
                while (it.hasNext()) {
                    String id = (String) it.next();
                    Composer composer = (Composer) composers.get(id);
                    if (composer.getFirstName().toLowerCase().startsWith(targetId)
                            || composer.getLastName().toLowerCase().startsWith(targetId)
                            || composer.getFirstName().toLowerCase().concat(" ").concat(composer.getLastName().toLowerCase()).startsWith(targetId)) {
                        sb.append("<composer>");
                        sb.append("<id>" + composer.getId() + "</id>");
                        sb.append("<firstName>" + composer.getFirstName() + "</firstName>");
                        sb.append("<lastName>" + composer.getLastName() + "</lastName>");
                        sb.append("</composer>");
                        namesAdded = true;
                    }
                }
            }
            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }
        if (action.equals("lookup")) {
            if ((targetId != null) && composers.containsKey(targetId.trim())) {
                request.setAttribute("composer", composers.get(targetId));
                context.getRequestDispatcher("/composer.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
