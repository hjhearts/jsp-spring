package SpringWeb7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        String action = request.getParameter("action");
        String nextPage= "";
        if(action == null || action.equals("listMembers")){
            List<MemberVO> membersList = dao.selectAllMemberList();
            request.setAttribute("membersList", membersList);
            nextPage = "spring2/listMembers.jsp";
        }else if(action.equals("selectMemberById")){
            String id = request.getParameter("value");
            MemberVO memberVO = dao.selectMemberById(id);
            request.setAttribute("member", memberVO);
            nextPage = "spring2/memberInfo.jsp";
        }else if(action.equals("selectMemberByPwd")){
            System.out.println("패스워드로 찾기");
            String pwd = request.getParameter("value");
            List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
            request.setAttribute("membersList", membersList);
            nextPage = "spring2/listMembers.jsp";
        }else if(action.equals("insertMember")){
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO addVO = new MemberVO();
            addVO.setId(id);
            addVO.setPwd(pwd);
            addVO.setName(name);
            addVO.setEmail(email);
            int status = dao.insertMember(addVO);
            nextPage = "mem2.do?action=listMembers";
        }else if(action.equals("updateMember")){
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO updateVO = new MemberVO();
            updateVO.setId(id);
            updateVO.setPwd(pwd);
            updateVO.setName(name);
            updateVO.setEmail(email);;
            dao.updateMember(updateVO);
            nextPage = "mem2.do?action=listMembers";
        }else if(action.equals("updateForm")){
            nextPage = "spring2/updateForm.jsp";
        }else if(action.equals("deleteMember")){
            String id = request.getParameter("id");
            dao.deleteMember(id);
            nextPage = "mem2.do?action=listMembers";
        }else if(action.equals("searchMember")){
            System.out.println("searchMember on");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO searchVO = new MemberVO();
            searchVO.setName(name);
            searchVO.setEmail(email);
            List<MemberVO> listMember = dao.searchMember(searchVO);
            request.setAttribute("membersList", listMember);
            nextPage = "spring2/listMembers.jsp";
        }else if(action.equals("searchMemberForm")){
            nextPage = "spring2/searchMember.jsp";
        }else if(action.equals("selectForEach")){
            List<String> nameList = new ArrayList<>();
            nameList.add("홍길동");
            nameList.add("관리자");
            nameList.add("한주성");
            List<MemberVO> membersList = dao.selectForEach(nameList);
            request.setAttribute("membersList", membersList);
            nextPage = "spring2/listMembers.jsp";
        }else if(action.equals("insertForEach")){
            List<MemberVO> memberList = new ArrayList<>();
            memberList.add(new MemberVO("test01", "testPwd01", "테스트1", "test1@test.com"));
            memberList.add(new MemberVO("test02", "testPwd02", "테스트2", "test2@test.com"));
            memberList.add(new MemberVO("test03", "testPwd03", "테스트3", "test3@test.com"));
            memberList.add(new MemberVO("test04", "testPwd04", "테스트4", "test4@test.com"));
            int status = dao.insertForEach(memberList);
            nextPage = "mem2.do?action=listMembers";
        }
        RequestDispatcher dis = request.getRequestDispatcher(nextPage);
        dis.forward(request, response);
    }
}
