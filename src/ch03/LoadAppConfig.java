package ch03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loadConfig", urlPatterns = {"/loadConfig"}, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
    private ServletContext context;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String menu_member = (String)context.getAttribute("menu_member");
        String menu_order = (String)context.getAttribute("menu_order");
        String menu_goods = (String)context.getAttribute("menu_goods");
        out.println("<html><body><table>");
        out.println("<tr><td>" + menu_member + "</td></tr>");
        out.println("<tr><td>" + menu_order + "</td></tr>");
        out.println("<tr><td>" + menu_goods + "</td></tr>");
        out.println("</table></body></html>");
    }
    @Override
    public void destroy() {

    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        String menu_member = context.getInitParameter("menu_member");
        String menu_order = context.getInitParameter("menu_order");
        String menu_goods = context.getInitParameter("menu_goods");
        context.setAttribute("menu_member", menu_member);
        context.setAttribute("menu_order", menu_order);
        context.setAttribute("menu_goods", menu_goods);

    }
}
