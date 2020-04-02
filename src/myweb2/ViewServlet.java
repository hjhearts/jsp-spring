package myweb2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        List<MemberBean> memberList = (List)request.getAttribute("memberList");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<table border=1><tr align='center'>");
        out.print("<td>ID</td><td>PASSWORD</td><td>NAME</td><td>EMAIL</td>" +
                "<td>JoinDate</td><td>Menu</td></tr>");
        for (int i = 0; i < memberList.size(); i++) {
            MemberBean curMember = memberList.get(i);
            out.print("<tr>");
            out.print("<td>" + curMember.getId() + "</td>");
            out.print("<td>" + curMember.getPwd() + "</td>");
            out.print("<td>" + curMember.getName() + "</td>");
            out.print("<td>" + curMember.getEmail() + "</td>");
            out.print("<td>" + curMember.getJoinDate() + "</td>");
            out.print("<td><a href='/member2?command=deleteMember&id="+ curMember.getId() +"'>DELETE</a></td>");
            out.print("</tr>");
        }
        out.print("</table><a href='/myweb1/memberConfirm.html'>ADD MEMBER</a>" +
                "</body></html>");
    }
}
