package SpringWeb7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/mem2.do")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doHandle(req, resp);
    }
    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO dao = new MemberDAO();
        /*
        String name = dao.selectName();
        int pwd = dao.selectPwd();
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('이름 : " + name + "');");
        out.println("alert('패스워드 : " + pwd + "');");
        out.println("</script>");

         */
        List<MemberVO> membersList = dao.selectAllMemberList();
        request.setAttribute("membersList", membersList);
        RequestDispatcher dis = request.getRequestDispatcher("spring2/listMembers.jsp");
        dis.forward(request, response);
    }
}
