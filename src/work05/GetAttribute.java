package work05;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/getAttr")
public class GetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        String ctxMsg = (String)context.getAttribute("context");
        String sesMsg = (String)session.getAttribute("session");
        String reqMsg = (String)request.getAttribute("request");
        out.println("<html><body>");
        out.println("Context값 : " + ctxMsg + "<br>");
        out.println("Session값 : " + sesMsg + "<br>");
        out.println("Request값 : " + reqMsg + "<br>");
        out.println("</body></html>");
    }
}
