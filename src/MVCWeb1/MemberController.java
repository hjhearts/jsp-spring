package MVCWeb1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
//@WebServlet("/member/*")
public class MemberController extends HttpServlet{

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
        MemberDAO memberDAO = new MemberDAO();
        String action = request.getPathInfo();
        String nextPage;
        System.out.println("action : " + action);
        if(action == null || action.equals("/listMembers.do")) {
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/work14/listMembers.jsp";
        }else if(action.equals("/addMember.do")){
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO addVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(addVO);
            request.setAttribute("msg", "add");
            nextPage = "/member/listMembers.do";
        }else if(action.equals("/memberForm.do")){
            nextPage = "/work14/memberForm.jsp";
        }else if(action.equals("/modMemberForm.do")){
            String id = request.getParameter("id");
            MemberVO modVO = memberDAO.findMemberById(id);
            System.out.println(modVO);
            request.setAttribute("modVO", modVO);
            nextPage = "/work14/modMemberForm.jsp";
        } else if(action.equals("/modMember.do")){
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO modVO = new MemberVO(id, pwd, name, email);
            memberDAO.modMember(modVO);
            request.setAttribute("msg", "modify");
            nextPage = "/member/listMembers.do";
        }else if(action.equals("/delMember.do")){
            String id = request.getParameter("id");
            memberDAO.delMember(id);
            request.setAttribute("msg", "delete");
            nextPage = "/member/listMembers.do";
        }else{
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/work14/listMembers.jsp";
        }
        RequestDispatcher dis = request.getRequestDispatcher(nextPage);
        dis.forward(request, response);
    }
}
