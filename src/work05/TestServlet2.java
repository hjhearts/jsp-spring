package work05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String context = request.getContextPath();
        String url = request.getRequestURL().toString();
        String mapping = request.getServletPath();
        String uri = request.getRequestURI();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TestServlet2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<b>Test Servlet1</b><br>");
        out.println("<b>컨텍스트 이름 : "+ context +"</b><br>");
        out.println("<b>전체 경로 : " + url +"</b><br>");
        out.println("<b>매핑이름 : " + mapping +"</b><br>");
        out.println("<b>URI : " + uri +"</b><br>");
        out.println("</body></html>");
        out.close();
    }
}
