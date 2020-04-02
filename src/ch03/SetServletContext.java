package ch03;
/*

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
@WebServlet("/cSet")
public class SetServletContext extends HttpServlet {
    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List member = new ArrayList<>();
        member.add("이순신");
        member.add(30);
        ServletContext sc = getServletContext();
        sc.setAttribute("member", member);
        out.println("<html><body>");
        out.println("이순신과 30설정");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {

    }
}

 */