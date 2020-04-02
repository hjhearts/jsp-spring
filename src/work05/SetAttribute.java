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
//@WebServlet("/setAttr")
public class SetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String ctxMsg = "Context에 바인딩됩니다.";
        String sesMes = "Session에 바인딩됩니다.";
        String reqMsg = "Request에 바인딩됩니다.";
        ServletContext ctx = getServletContext();
        HttpSession session = request.getSession();
        ctx.setAttribute("context", ctxMsg);
        session.setAttribute("session", sesMes);
        request.setAttribute("request", reqMsg);
        out.println("Binding");
    }
}
