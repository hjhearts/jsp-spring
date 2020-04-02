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
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/loginTest")
public class LoginTestServlet extends HttpServlet {
    List<String> user_list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext context = getServletContext();
        PrintWriter out = response.getWriter();
        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        HttpSession session = request.getSession();
        LoginImplServlet event = new LoginImplServlet(user_id, user_pwd);
        if(session.isNew()) {
            session.setAttribute("loginUser", event);
            user_list.add(user_id);
            context.setAttribute("user_list", user_list);
        }
        out.println("<html><body>");
        out.println("아이디 : " + user_id + "<br>");
        out.println("총접속자 : " + LoginImplServlet.total_user + "<br>");
        out.println("접속 아이디<br>");
        List list = (ArrayList)context.getAttribute("user_list");
        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i) + "<br>");
        }
        out.println("<a href='/logout?user_id=" + user_id + "'>LOGOUT</a>");
        out.println("</body>");
        out.println("<script>");
        out.println("setTimeout('history.go(0);', 5000)");
        out.println("</script>");
        out.println("</html>");
    }
}
