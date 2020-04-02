package work13;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
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
        String result = "<main>\n" +
                "    <book>\n" +
                "        <title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>\n" +
                "        <writer><![CDATA[인포북스 저 | 이병승]]></writer>\n" +
                "        <image><![CDATA[image/image1.jpg]]></image>\n" +
                "    </book>\n" +
                "    <book>\n" +
                "        <title><![CDATA[모두의 파이썬]]></title>\n" +
                "        <writer><![CDATA[길벗 저 | 이승찬]]></writer>\n" +
                "        <image><![CDATA[image/image2.jpg]]></image>\n" +
                "    </book>\n" +
                "</main>";
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
