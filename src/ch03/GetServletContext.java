package ch03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/cGet")
public class GetServletContext extends HttpServlet {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        String menu_member = context.getInitParameter("menu_member");
        String menu_order = context.getInitParameter("menu_order");
        String menu_goods = context.getInitParameter("menu_goods");
        out.println("<html><body>");
        out.println("<table>");
        out.println("<tr><td>" + menu_member + "</td></tr>");
        out.println("<tr><td>" + menu_order + "</td></tr>");
        out.println("<tr><td>" + menu_goods + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}