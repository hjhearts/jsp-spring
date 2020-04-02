package myweb2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
    public void init(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("GET 요청이 들어왔습니다.");
        System.out.println("요청 URI : " + request.getRequestURI());
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("POST 요청이 들어왔습니다.");
        System.out.println("요청 URI : " + request.getRequestURI());
        doHandle(request, response);
    }
    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        System.out.println("Handle called");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        MemberDAO dao = new MemberDAO();
        List<MemberBean> memberList = dao.listMembers();
        request.setAttribute("memberList", memberList);
        //RequestDispatcher dis = request.getRequestDispatcher("/viewMembers");
        //dis.forward(request, response);

        String command = (String)request.getParameter("command");
        if(command != null && command.equals("addMember")) {
            String id = request.getParameter("user_id");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberBean bean = new MemberBean();
            bean.setId(id);
            bean.setPwd(password);
            bean.setName(name);
            bean.setEmail(email);
            dao.add(bean);
            response.sendRedirect("/member2");
        }else if(command != null && command.equals("deleteMember")){
            String id = request.getParameter("id");
            dao.delete(id);
        }else if(command != null && command.equals("overLappedCheck")){
            PrintWriter out = response.getWriter();
            System.out.println("overLapped start");
            String id = request.getParameter("id");
            boolean overLapped = (boolean) dao.overLapped(id);
            if(overLapped == true){
                System.out.println("not_usable 값을 전달합니다.");
                System.out.println(response.getStatus());
                out.print("not_usable");
            } else {
                System.out.println("usable 값을 전달합니다.");
                System.out.println(response.getStatus());
                out.print("usable");
            }
        }
    }
    public void destroy(){}
}
