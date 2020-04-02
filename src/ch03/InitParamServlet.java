package ch03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {
                "/sInit",
                "/sInit2"
        },
        initParams = {
                @WebInitParam(name="email", value = "admin@test.com"),
                @WebInitParam(name="tel", value="010-1111-2222")
        }
)
public class InitParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String email = getInitParameter("email");
        String tel = getInitParameter("tel");
        out.println("<html><body>");
        out.println("email : " + email);
        out.println("<br>tel : " + tel);
        out.println("</body></html>");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
